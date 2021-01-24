/*
 * This file is part of GriefDefender, licensed under the MIT License (MIT).
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
package com.griefdefender.api.provider;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.griefdefender.api.Clan;
import com.griefdefender.api.ClanPlayer;

public interface ClanProvider {

    /**
     * Gets a list of {@link Clan}'s available.
     * 
     * @return The clan list or empty list if none
     */
    List<Clan> getClans();

    /**
     * Gets a list of all {@link ClanPlayer}'s available.
     * 
     * @return The clan player list or empty list if none
     */
    List<ClanPlayer> getClanPlayers();

    /**
     * Gets clan with tag.
     * 
     * @param tag The clan tag
     * @return The clan, if available
     */
    Optional<Clan> getClan(String tag);

    /**
     * Gets the {@link ClanPlayer}.
     * 
     * @param playerUniqueId The player uuid
     * @return The clan player, if available
     */
    Optional<ClanPlayer> getClanPlayer(UUID playerUniqueId);
}
