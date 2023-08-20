package cc.ddev.instanceguard.listener.handler;

import cc.ddev.instanceguard.logger.Log;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventFilter;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.EventNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Listener<T extends Event> {
    EventFilter<T, ?> getFilter();
    default EventNode<?> register() {
        var methods = this.getClass().getDeclaredMethods();
        var node = EventNode.type("instanceguard-"+this.getClass().getSimpleName().toLowerCase(), getFilter());

        for (Method method : methods) {
            if (!method.isAnnotationPresent(Listen.class)) continue;
            var paramTypes = method.getParameterTypes();
            if (!(paramTypes.length == 1 && getFilter().eventType().isAssignableFrom(paramTypes[0]))) {
                throw new IllegalArgumentException("Method annotated with @Listen must have a single parameter of type Event or a subclass of Event.");
            }
            Class<?> eventToStickTo = paramTypes[0];
            // Check if the event is a subclass of Event
            if (!getFilter().eventType().isAssignableFrom(eventToStickTo)){
                throw new IllegalArgumentException("Method `"+method.getName()+"`'s 1st parameter is not assignable to type `"+getFilter().eventType().getSimpleName()+"`!");
            }
            if(getFilter().getClass().isAssignableFrom(eventToStickTo)) {
                // code intellisense yells here but the code does check if the event is (assignable to) Class<T>
                node.addListener((Class<T>) eventToStickTo, (event) -> {
                    try {
                        method.invoke(this, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
                Log.getLogger().debug("Registered listener for event " + eventToStickTo.getSimpleName() + " to node "+node.getName());
            }
        }
        return node;
    }
}