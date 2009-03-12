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
package com.xpn.xwiki.wysiwyg.client.dom;

/**
 * Extends the {@link com.google.gwt.dom.client.Style} to add constants for standard property names and values.
 * 
 * @version $Id$
 */
public class Style extends com.google.gwt.dom.client.Style
{
    /**
     * Sets how/if an element is displayed.
     */
    public static final String DISPLAY = "display";

    /**
     * Sets the background color of an element.
     */
    public static final String BACKGROUND_COLOR = "backgroundColor";

    /**
     * Sets the stack order of an element. An element with greater stack order is always in front of another element
     * with lower stack order.<br/>
     * Elements can have negative stack orders.<br/>
     * Z-index only works on elements that have been positioned (eg position:absolute;)!
     */
    public static final String Z_INDEX = "zIndex";

    /**
     * Sets how thick or thin characters in text should be displayed.
     */
    public static final String FONT_WEIGHT = "font-weight";

    /**
     * Sets the style of a font.
     */
    public static final String FONT_STYLE = "font-style";

    /**
     * Decorates the text.
     */
    public static final String TEXT_DECORATION = "text-decoration";

    /**
     * The font-family property is a prioritized list of font family names and/or generic family names for an element.
     * The browser will use the first value it recognizes.<br/>
     * There are two types of font-family values:
     * <ul>
     * <li>family-name: "times", "courier", "arial", etc.</li>
     * <li>generic-family: "serif", "sans-serif", "cursive", "fantasy", "monospace".</li>
     * </ul>
     * Note: Separate each value with a comma, and always offer a generic-family name as the last alternative.<br/>
     * Note: If a family-name contains white-space, it should be quoted. Single quotes must be used when using the
     * "style" attribute in HTML.
     */
    public static final String FONT_FAMILY = "font-family";

    /**
     * Sets the width of an element.
     */
    public static final String WIDTH = "width";

    /**
     * sets the height of an element.
     */
    public static final String HEIGHT = "height";

    /**
     * Sets how far the top edge of an element is above/below the top edge of the parent element.
     */
    public static final String TOP = "top";

    /**
     * Sets how far the left edge of an element is to the right/left of the left edge of the parent element.
     */
    public static final String LEFT = "left";

    /**
     * Places an element in a static, relative, absolute or fixed position.
     */
    public static final String POSITION = "position";

    /**
     * Standard values for {@link Style#DISPLAY}.
     */
    public static final class Display
    {
        /**
         * Default. The element will be displayed as an inline element, with no line break before or after the element.
         */
        public static final String INLINE = "inline";

        /**
         * The element will be displayed as a block-level element, with a line break before and after the element.
         */
        public static final String BLOCK = "block";

        /**
         * The element will not be displayed.
         */
        public static final String NONE = "none";

        /**
         * This is a utility class so it has a private constructor.
         */
        private Display()
        {
        }
    }

    /**
     * Standard values for {@link Style#FONT_WEIGHT}.
     */
    public static final class FontWeight
    {
        /**
         * Defines thick characters.
         */
        public static final String BOLD = "bold";

        /**
         * Defines thicker characters.
         */
        public static final String BOLDER = "bolder";

        /**
         * This is a utility class so it has a private constructor.
         */
        private FontWeight()
        {
        }
    }

    /**
     * Standard values for {@link Style#FONT_STYLE}.
     */
    public static final class FontStyle
    {
        /**
         * The browser displays an italic font.
         */
        public static final String ITALIC = "italic";

        /**
         * This is a utility class so it has a private constructor.
         */
        private FontStyle()
        {
        }
    }

    /**
     * Standard values for {@link Style#TEXT_DECORATION}.
     */
    public static final class TextDecoration
    {
        /**
         * Defines a line through the text.
         */
        public static final String LINE_THROUGH = "line-through";

        /**
         * Defines a line under the text.
         */
        public static final String UNDERLINE = "underline";

        /**
         * This is a utility class so it has a private constructor.
         */
        private TextDecoration()
        {
        }
    }

    /**
     * Standard values for {@link Style#POSITION}.
     */
    public static final class Position
    {
        /**
         * Default. An element with position: static always has the position the normal flow of the page gives it (a
         * static element ignores any top, bottom, left, or right declarations).
         */
        public static final String STATIC = "static";

        /**
         * An element with position: relative moves an element relative to its normal position, so "left:20" adds 20
         * pixels to the element's LEFT position.
         */
        public static final String RELATIVE = "relative";

        /**
         * An element with position: absolute is positioned at the specified coordinates relative to its containing
         * block. The element's position is specified with the "left", "top", "right", and "bottom" properties.
         */
        public static final String ABSOLUTE = "absolute";

        /**
         * An element with position: fixed is positioned at the specified coordinates relative to the browser window.
         * The element's position is specified with the "left", "top", "right", and "bottom" properties. The element
         * remains at that position regardless of scrolling. Works in IE7 (strict mode).
         */
        public static final String FIXED = "fixed";

        /**
         * This is a utility class so it has a private constructor.
         */
        private Position()
        {
        }
    }

    /**
     * Default constructor. Needs to be protected because all instances are created from JavaScript.
     */
    protected Style()
    {
    }

    /**
     * Some browsers expect the camel case form of a style property. For instance, the camel case form of "font-weight"
     * is "fontWeight".
     * 
     * @param propertyName The name of style property.
     * @return The camel case form of the given property name.
     */
    public static String toCamelCase(String propertyName)
    {
        int dashIndex = propertyName.indexOf('-');
        if (dashIndex < 0 || dashIndex == propertyName.length() - 1) {
            return propertyName;
        }
        StringBuffer camelCase = new StringBuffer(propertyName.substring(0, dashIndex));
        camelCase.append(propertyName.substring(dashIndex + 1, dashIndex + 2).toUpperCase());
        camelCase.append(propertyName.substring(dashIndex + 2));
        return camelCase.toString();
    }
}
