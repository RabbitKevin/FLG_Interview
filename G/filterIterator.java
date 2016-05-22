class filterIterator implements Iterator<E> {
    Iterator<E> source;
    E candidate;
    public filterIterator(Iterator source) {
        this.source = source;
        help();
    }

    public boolean hasNext() {
        return candidate != null;
    }

    public E next() {
        E result = candidate;
        help();
        return result;
    }

    private void help() {
        E num;
        while(source.hasNext() && num == null) {
            num = source.next();
        }
        candidate = num;
    }
}
