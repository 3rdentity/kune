/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.wysiwyg.client.dom.internal.mozilla;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Node;
import com.xpn.xwiki.wysiwyg.client.dom.DOMUtils;
import com.xpn.xwiki.wysiwyg.client.dom.Document;
import com.xpn.xwiki.wysiwyg.client.dom.Element;

/**
 * Contains methods from {@link DOMUtils} that require a different implementation in Mozilla.
 * 
 * @version $Id$
 */
public class MozillaDOMUtils extends DOMUtils
{
    /**
     * {@inheritDoc}
     * 
     * @see DOMUtils#getComputedStyleProperty(Element, String)
     */
    public native String getComputedStyleProperty(Element el, String propertyName)
    /*-{
        // We force it to be a string because we treat it as a string in the java code.
        return '' + el.ownerDocument.defaultView.getComputedStyle(el, null).getPropertyValue(propertyName);
    }-*/;

    /**
     * {@inheritDoc}
     * 
     * @see DOMUtils#importNode(Document, Node, boolean)
     */
    public native Node importNode(Document doc, Node externalNode, boolean deep)
    /*-{
        return doc.importNode(externalNode, deep);
    }-*/;

    /**
     * {@inheritDoc}
     * 
     * @see DOMUtils#getAttributeNames(Element)
     */
    public native JsArrayString getAttributeNames(Element element)
    /*-{
        var attrNames = [];
        for(var i = 0; i < element.attributes.length; i++) {
            attrNames.push(element.attributes.item(i));
        }
        return attrNames;
    }-*/;

    /**
     * {@inheritDoc}
     * 
     * @see DOMUtils#setInnerHTML(Element, String)
     */
    public void setInnerHTML(Element element, String html)
    {
        element.setInnerHTML(html);
    }

    /**
     * {@inheritDoc}
     * 
     * @see DOMUtils#splitHTMLNode(Node, Node, int)
     */
    public Node splitHTMLNode(Node parent, Node descendant, int offset)
    {
        // Save the length of the descendant before the split to be able to detect where the split took place.
        int length = getLength(descendant);

        // Split the subtree rooted in the given parent.
        Node nextLevelSibling = super.splitHTMLNode(parent, descendant, offset);

        // See if the split took place.
        if (nextLevelSibling != descendant) {
            if (offset == 0) {
                // The split took place at the beginning of the descendant. Ensure the first subtree is accessible.
                // But first see if the first subtree has any leafs besides the descendant.
                Node child = getChild(parent, descendant);
                if (!isInline(child) && getFirstLeaf(child) == descendant) {
                    Node refNode = getFarthestInlineAncestor(descendant);
                    refNode = refNode == null ? child : refNode.getParentNode();
                    refNode.appendChild(((Document) refNode.getOwnerDocument()).xCreateBRElement());
                }
            }
            if (offset == length) {
                // The split took place at the end of the descendant. Ensure the second subtree is accessible.
                // But first see if the second subtree has any leafs besides the nextLevelSibling.
                Node child = getChild(parent, nextLevelSibling);
                if (!isInline(child) && getLastLeaf(child) == nextLevelSibling) {
                    Node refNode = getFarthestInlineAncestor(nextLevelSibling);
                    refNode = refNode == null ? child : refNode.getParentNode();
                    refNode.appendChild(((Document) refNode.getOwnerDocument()).xCreateBRElement());
                }
            }
        }

        return nextLevelSibling;
    }
}
