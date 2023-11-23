package edu.itmo.project.lesson1819;

public interface IPay {
    boolean pay();
    default IPay additionalPay(IPay another) {
        return () -> {if (!pay()) return another.pay(); return true;
        };
    }
}
