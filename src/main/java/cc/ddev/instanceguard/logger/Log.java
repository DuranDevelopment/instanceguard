package cc.ddev.instanceguard.logger;

import cc.ddev.instanceguard.InstanceGuard;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    @Getter
    public static final Logger logger = LoggerFactory.getLogger(InstanceGuard.class);
}