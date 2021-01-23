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
package com.griefdefender.api.event;

import java.util.Set;

import com.griefdefender.api.claim.Claim;

/**
 * An event that is fired when a {@link Group}'s trust changes in a {@link Claim}.
 */
public interface GroupTrustClaimEvent extends TrustClaimEvent {

    /**
     * Gets the list of groups requesting trust.
     * 
     * @return The list of groups requesting trust
     */
    Set<String> getGroups();

    /**
     * Fired when a group is added to claim trust.
     */
    interface Add extends GroupTrustClaimEvent, TrustClaimEvent.Add {};

    /**
     * Fired when a group is removed from claim trust.
     */
    interface Remove extends GroupTrustClaimEvent, TrustClaimEvent.Remove {};
}
