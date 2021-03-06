/*-
 * ========================LICENSE_START=================================
 * Smooks Core
 * %%
 * Copyright (C) 2020 Smooks
 * %%
 * Licensed under the terms of the Apache License Version 2.0, or
 * the GNU Lesser General Public License version 3.0 or later.
 * 
 * SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
 * 
 * ======================================================================
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ======================================================================
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * =========================LICENSE_END==================================
 */
package org.smooks.delivery.memento;

import org.smooks.delivery.Visitor;

/**
 * Holds the state of a {@link Visitor}. 
 * 
 * A <code>VisitorMemento</code> is saved and restored it at a later stage. A <code>VisitorMemento</code> is bound to a 
 * <code>Visitor<code></> and its visitable (e.g., {@link NodeVisitable}). Management of <code>VisitorMemento</code>s
 * should be delegated to {@link org.smooks.container.MementoCaretaker}.
 */
public interface VisitorMemento  {

    /**
     * Performs a deep clone of this <code>VisitorMemento</code>.
     * 
     * @return a deep clone of this <code>VisitorMemento</code>
     */
    VisitorMemento copy();

    /**
     * Combines a <code>VisitorMemento</code> state with this <code>VisitorMemento</code>
     * 
     * @param visitorMemento  the <code>VisitorMemento</code> restoring this <code>VisitorMemento</code>
     */
    void restore(VisitorMemento visitorMemento);

    /**
     * @return the <code>Visitor</code> which this <code>VisitorMemento</code> is bound to
     */
    Visitor getVisitor();

    /**
     * @return the visitable which this <code>VisitorMemento</code> is bound to
     */
    Visitable getVisitable();

    /**
     * Gets the ID of this <code>VisitorMemento</code>. <code>VisitorMemento</code>s with equal IDs are considered to be 
     * capturing the state of the same object but at different points in time.
     * 
     * @return the ID of this <code>VisitorMemento</code>
     */
    String getId();
    
}
