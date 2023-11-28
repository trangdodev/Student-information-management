package Client;

public interface SubjectNotify {
    void attach(ObserverNotify observer);

    void detach(ObserverNotify observer);
}
