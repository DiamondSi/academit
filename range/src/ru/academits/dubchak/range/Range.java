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
        double intersectionFrom = Math.max(from, range.from);
        double intersectionTo = Math.min(to, range.to);
        double intersectionLength = intersectionTo - intersectionFrom;
        if (intersectionLength <= 0) {
            return null;
        } else {
            return new Range(intersectionFrom, intersectionTo);
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.min(to, range.to) - Math.max(from, range.from) >= 0) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        } else {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }
    }

    public Range[] getDifference(Range range) {
        if (from < range.from && to <= range.to) {
            return new Range[]{new Range(from, Math.min(to, range.from))};
        } else if (from >= range.from && to > range.to) {
            return new Range[]{new Range(Math.max(from, range.to), to)};
        } else if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else {
            return new Range[]{};
        }
    }
}
