package ru.academits.dubchak.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }

    public Range getIntersection(Range range) {
        double intersectionFrom = Math.max(getFrom(), range.getFrom());
        double intersectionTo = Math.min(getTo(), range.getTo());
        double intersectionLength = intersectionTo - intersectionFrom;
        if (intersectionLength < 0) {
            return null;
        } else {
            return new Range(intersectionFrom, intersectionTo);
        }
    }

    public Range[] getUnion(Range range) {
        if (getIntersection(range) != null) {
            return new Range[]{new Range(Math.min(getFrom(), range.getFrom()), Math.max(getTo(), range.getTo()))};
        } else {
            return new Range[]{new Range(getFrom(), getTo()), new Range(range.getFrom(), range.getTo())};
        }
    }

    public Range[] getDifference(Range range) {
        Range intersection = this.getIntersection(range);

        if (intersection == null) {
            return new Range[]{new Range(getFrom(), getTo())};
        } else if (range.getLength() >= getLength()) {
            return new Range[]{};
        } else
//        return new Range[]{new Range(Math.min(getFrom(), range.getFrom()), Math.max(getTo(), range.getTo()))};

            if (getTo() < range.getTo() && getTo() < range.getTo()) {
                return new Range[]{new Range(getFrom(), Math.min(getTo(), range.getFrom()))};
            } else if (getFrom() < range.getTo() && getTo() > range.getTo())
                return new Range[]{};
    }
}
