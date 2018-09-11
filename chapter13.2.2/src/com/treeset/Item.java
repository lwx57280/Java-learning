package com.treeset;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;

    private int partNumber;

    /**
     * 有描述和零件编号的ITME
     * @param description
     * @param partNumber
     */
    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item item = (Item) obj;

        return Objects.equals(description, ((Item) obj).description) && partNumber == ((Item) obj).partNumber;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber,o.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }
}
