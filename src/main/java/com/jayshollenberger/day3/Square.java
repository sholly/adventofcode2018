package com.jayshollenberger.day3;

public class Square {

    private Integer id;
    private Integer startX;
    private Integer startY;
    private Integer sizeX;
    private Integer sizeY;
    private Integer endX;
    private Integer endY;

    public Square(Integer id, Integer startX, Integer startY, Integer sizeX, Integer sizeY) {
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.endX = startX + (sizeX-1);
        this.endY = startY + (sizeY-1);
    }

    public Integer id() {
        return id;
    }

    public Integer startX() {
        return startX;
    }

    public Integer startY() {
        return startY;
    }

    public Integer sizeX() {
        return sizeX;
    }

    public Integer sizeY() {
        return sizeY;
    }

    public Integer endX() {
        return endX;
    }

    public Integer endY() {
        return endY;
    }

    @Override
    public String toString() {
        return "Square{" +
                "id=" + id +
                ", startX=" + startX +
                ", startY=" + startY +
                ", sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}
