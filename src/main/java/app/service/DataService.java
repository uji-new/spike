package app.service;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    final static protected String BACKEND = "target/data.bin";

    public void save(Object object) {
        synchronized (this) {
            try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(BACKEND))) {
                stream.writeObject(object);
            } catch (IOException ignored) {}
        }
    }

    public Object load() {
        synchronized (this) {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(BACKEND))) {
                return stream.readObject();
            } catch (IOException | ClassNotFoundException ignored) {
                return null;
            }
        }
    }
}
