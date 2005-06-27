/* Copyright 2004, 2005 Acegi Technology Pty Limited
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
 */

package net.sf.acegisecurity.ui;

import net.sf.acegisecurity.Authentication;

import org.springframework.context.ApplicationEvent;

import org.springframework.util.Assert;


/**
 * Indicates an interactive authentication was successful.
 * 
 * <P>
 * The <code>ApplicationEvent</code>'s <code>source</code> will be the
 * <code>Authentication</code> object.
 * </p>
 *
 * @author Ben Alex
 * @version $Id$
 */
public class InteractiveAuthenticationSuccesEvent extends ApplicationEvent {
    //~ Instance fields ========================================================

    private Class generatedBy;

    //~ Constructors ===========================================================

    public InteractiveAuthenticationSuccesEvent(Authentication authentication,
        Class generatedBy) {
        super(authentication);
        Assert.notNull(generatedBy);
        this.generatedBy = generatedBy;
    }

    //~ Methods ================================================================

    /**
     * Getters for the <code>Authentication</code> request that caused the
     * event. Also available from <code>super.getSource()</code>.
     *
     * @return the authentication request
     */
    public Authentication getAuthentication() {
        return (Authentication) super.getSource();
    }

    /**
     * Getter for the <code>Class</code> that generated this event. This can be
     * useful for generating additional logging information.
     *
     * @return
     */
    public Class getGeneratedBy() {
        return generatedBy;
    }
}
