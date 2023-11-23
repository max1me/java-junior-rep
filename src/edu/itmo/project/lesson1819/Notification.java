package edu.itmo.project.lesson1819;

import java.util.function.Predicate;

@FunctionalInterface
public interface Notification {
    void send (String message);

    default Notification additionalSend(Notification other, Predicate<String> predicate) {
        return (message) -> {
            if (predicate.test(message)) other.send(message);
            send(message);
        };
    }
}
