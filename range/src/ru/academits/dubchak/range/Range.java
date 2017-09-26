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
        double intersectionFrom = Math.max(this.getFrom(), range.getFrom());
        double intersectionTo = Math.min(this.getTo(), range.getTo());
        double intersectionLength = intersectionTo - intersectionFrom;
        if (intersectionLength < 0) {
            return null;
        } else return new Range(intersectionFrom, intersectionTo);
    }

    public Range[] getDisjunction(Range range) {
        double disjunctionFrom = Math.min(this.getFrom(), range.getFrom());
        double disjunctionTo = Math.max(this.getTo(), range.getTo());
        if (this.getIntersection(range) != null) {
            return new Range[]{new Range(disjunctionFrom, disjunctionTo)};
        } else return new Range[]{new Range(this.getFrom(), getTo()), new Range(range.getFrom(), range.getTo())};
    }
}
