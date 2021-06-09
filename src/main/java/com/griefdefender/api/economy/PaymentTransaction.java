/*
 * This file is part of GriefDefenderAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) bloodmc
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.griefdefender.api.economy;

import com.griefdefender.api.GriefDefender;

import java.time.Instant;
import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Contains information of a payment transaction in a claim.
 */
public interface PaymentTransaction {

    /**
     * Gets the {@link TransactionType}.
     * 
     * @return The type
     */
    TransactionType getType();

    /**
     * Gets the {@link TransactionResultType}.
     * 
     * @return The result
     */
    TransactionResultType getResultType();

    /**
     * Gets the source of this transaction.
     * 
     * @return The source, if available
     */
    @Nullable UUID getSource();

    /**
     * Gets the timestamp of this transaction.
     * 
     * @return The timestamp
     */
    Instant getTimestamp();

    /**
     * Gets the amount of the this transaction.
     * 
     * @return The amount
     */
    Double getAmount();

    /**
     * Gets a new {@link PaymentTransaction} builder instance.
     * 
     * @return A new payment transaction builder instance
     */
    public static PaymentTransaction.Builder builder() {
        return GriefDefender.getRegistry().createBuilder(PaymentTransaction.Builder.class);
    }

    public interface Builder {

        Builder type(TransactionType type);

        Builder result(TransactionResultType type);

        Builder source(UUID source);

        Builder amount(double amount);

        Builder reset();

        PaymentTransaction build();
    }
}
