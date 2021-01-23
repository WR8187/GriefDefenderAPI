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
package com.griefdefender.api.claim;

import com.flowpowered.math.vector.Vector3i;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Used to manage one or more {@link Claim}'s in a world.
 */
public interface ClaimManager {

    /**
     * Gets the wilderness claim of this manager's world.
     * 
     * @return The wilderness claim
     */
    Claim getWildernessClaim();

    /**
     * Gets the {@link Claim} at specified position.
     * 
     * @param pos The pos to check
     * @return The claim if available, otherwise returns the wilderness claim
     * if none were found.
     */
    Claim getClaimAt(Vector3i pos);

    /**
     * Gets the {@link Claim} at specified position.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return The claim if available, otherwise returns the wilderness claim
     * if none were found.
     */
    Claim getClaimAt(int x, int y, int z);

    /**
     * Gets the {@link Claim} with specified {@link UUID}.
     * 
     * @param claimUniqueId The claim UUID to search for
     * @return The claim, if available
     */
    Optional<Claim> getClaimByUUID(UUID claimUniqueId);

    /**
     * Gets a list of {@link Claim}'s with specified name.
     * 
     * @param name The claim name to search for
     * @return The list of claims, empty list if none were found
     */
    List<Claim> getClaimsByDisplayName(String name);

    /**
     * Gets an immutable list of player {@link Claim}'s for specified {@link UUID}.
     * 
     * Note: This will return an empty list if player has no claims.
     * 
     * @param playerUniqueId The player UUID
     * @return An immutable list of claims, empty list if none were found
     */
    Set<Claim> getPlayerClaims(UUID playerUniqueId);

    /**
     * Gets an immutable list all world {@link Claim}'s for specified {@link UUID}.
     * 
     * Note: This will return an empty list if no world claims are found.
     * 
     * @return An immutable list of world claims, empty list if none were found
     */
    Set<Claim> getWorldClaims();

    /**
     * Gets an immutable map of chunk hashes to {@link Claim}'s.
     * 
     * @return An immutable map of chunk hashes to claims, empty map if none exist.
     */
    Map<Long, Set<Claim>> getChunksToClaimsMap();

    /**
     * Deletes a {@link Claim} from the managed world.
     * 
     * @param claim The claim to delete
     * @return The claim result
     */
    default ClaimResult deleteClaim(Claim claim) {
        return this.deleteClaim(claim, true);
    }

    /**
     * Deletes a {@link Claim} from the managed world.
     * 
     * Note: If children are not deleted, they will be moved
     * to parent claim if one exists. If no parent exists, they
     * will simply be moved to wilderness.
     * 
     * @param claim The claim to delete
     * @param deleteChildren Whether to delete children
     * @return The claim result
     */
    ClaimResult deleteClaim(Claim claim, boolean deleteChildren);

    /**
     * Gets the managed {@link UUID}.
     * 
     * @return The managed world uuid
     */
    UUID getWorldId();
}
