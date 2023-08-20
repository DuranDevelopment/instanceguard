package cc.ddev.instanceguard.listener.handler;

import cc.ddev.instanceguard.logger.Log;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Listener {
    EventFilter<?, ?> getFilter();
    default EventNode<?> register() {
        var methods = this.getClass().getDeclaredMethods();
        var node = EventNode.type("instanceguard-"+this.getClass().getSimpleName().toLowerCase(), getFilter());

        for (Method method : methods) {
            if (method.isAnnotationPresent(Listen.class)) {
                var paramTypes = method.getParameterTypes();
                // Check if the method has a single parameter of type Event or a subclass of Event
                if(paramTypes.length == 1 && Event.class.isAssignableFrom(paramTypes[0])) {
                    // Get the class of the event from the parameter type
                    Class<?> eventToStickTo = paramTypes[0];
                    // Check if the event is a subclass of Event
                    if(Event.class.isAssignableFrom(eventToStickTo)) {
                        // Register the event

                        node.addListener(eventToStickTo.asSubclass(Event.class), event -> {
                            try {
                                method.invoke(this, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        if (Log.getLogger().isDebugEnabled()) Log.getLogger().debug("Registered listener for event " + eventToStickTo.getSimpleName());
                    } else {
                        throw new IllegalArgumentException("Method annotated with @Listen must have a single parameter of type Event or a subclass of Event.");
                    }
                } else {
                    throw new IllegalArgumentException("Method annotated with @Listen must have a single parameter of type Event or a subclass of Event.");
                }
            }
        }
        return node;
    }
}