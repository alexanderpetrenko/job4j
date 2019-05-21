package ru.job4j.generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> data;

    public AbstractStore(int size) {
        this.data = new SimpleArray<>(size);
    }

    private int getId(String id) {
        int index = 0;
        for (var element : data) {
            if (element.getId().equals(id)) {
                break;
            }
            index++;
        }
        return index < this.data.length() ? index : -1;
    }

    public int length() {
        return this.data.length();
    }

    @Override
    public void add(T model) {
        this.data.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean success = false;
        int position = this.getId(id);
        if (position != -1) {
            this.data.set(position, model);
            success = true;
        }
        return success;
    }

    @Override
    public boolean delete(String id) {
        boolean success = false;
        int position = this.getId(id);
        if (position != -1) {
            this.data.remove(position);
            success = true;
        }
        return success;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int position = this.getId(id);
        if (position != -1) {
            result = this.data.get(position);
        }
        return result;
    }
}
