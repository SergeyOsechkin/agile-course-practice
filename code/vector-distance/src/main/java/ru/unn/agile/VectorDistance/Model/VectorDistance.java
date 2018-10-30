package ru.unn.agile.vectordistance.model;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class VectorDistance {
    public static float computeL1(final FloatVector a, final FloatVector b) {
        final double p = 1.0;
        return computeLPdistance(a, b, p);
    }

    public static float computeL2(final FloatVector a, final FloatVector b) {
        final double p = 2.0;
        return computeLPdistance(a, b, p);
    }

    public static float computeL3(final FloatVector a, final FloatVector b) {
        final double p = 3.0;
        return computeLPdistance(a, b, p);
    }

    public static float computeL4(final FloatVector a, final FloatVector b) {
        final double p = 4.0;
        return computeLPdistance(a, b, p);
    }

    public static float computeLinf(final FloatVector a, final FloatVector b) {
        checkArgs(a, b);

        float distance = 0.0f;
        for (int i = 0; i < a.length(); ++i) {
            float currentDistance = Math.abs(a.get(i) - b.get(i));
            ensureIsFinite(currentDistance);
            if (distance < currentDistance) {
                distance = currentDistance;
            }
        }
        return distance;
    }

    private VectorDistance() { /* none */ }

    private static float computeLPdistance(
            final FloatVector a, final FloatVector b, final double p) {
        checkArgs(a, b);

        float distance = 0.0f;
        for (int i = 0; i < a.length(); ++i) {
            distance += Math.pow(Math.abs(a.get(i) - b.get(i)), p);
            ensureIsFinite(distance);
        }
        return (float) Math.pow(distance, 1.0 / p);
    }

    private static void ensureIsFinite(final float x) {
        if (!Float.isFinite(x)) {
            throw new FloatingOverflowException("Floating overflow");
        }
    }

    private static void checkArgs(final FloatVector a, final FloatVector b) {
        Objects.requireNonNull(a, "Expected not null parameter a");
        Objects.requireNonNull(b, "Expected not null parameter b");
        if (a.length() != b.length()) {
            throw new InvalidParameterException(
                "Expected vectors of same length");
        }
    }
}
