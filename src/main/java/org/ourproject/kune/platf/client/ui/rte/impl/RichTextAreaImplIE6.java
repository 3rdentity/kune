/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ourproject.kune.platf.client.ui.rte.impl;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * IE6-specific implementation of rich-text editing.
 */
public class RichTextAreaImplIE6 extends RichTextAreaImplStandard {

    @Override
    public Element createElement() {
        Element elem = super.createElement();
        DOM.setElementProperty(elem, "src", "javascript:''");
        return elem;
    }

    @Override
    public native void initElement() /*-{
       var _this = this;
       _this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImplStandard::initializing = true;

       setTimeout(function() {
         if (_this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImplStandard::initializing == false) {
           return;
         }

         // Attempt to set the iframe document's body to 'contentEditable' mode.
         // There's no way to know when the body will actually be available, so
         // keep trying every so often until it is.
         // Note: The body seems to be missing only rarely, so please don't remove
         // this retry loop just because it's hard to reproduce.
         var elem = _this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImpl::elem;
         var doc = elem.contentWindow.document;
         if (!doc.body) {
             // Retry in 50 ms. Faster would run the risk of pegging the CPU. Slower
             // would increase the probability of a user-visible delay.
           setTimeout(arguments.callee, 50);
           return;
         }
         doc.body.contentEditable = true;

         // Send notification that the iframe has reached design mode.
         _this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImplStandard::onElementInitialized()();
       }, 1);
     }-*/;

    @Override
    protected native String getTextImpl() /*-{
       var elem = this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImpl::elem;
       return elem.contentWindow.document.body.innerText;
     }-*/;

    @Override
    protected native void hookEvents() /*-{
       var elem = this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImpl::elem;
       var body = elem.contentWindow.document.body;

       var handler = function() {
         if (elem.__listener) {
           // Weird: this code has the context of the script frame, but we need the
           // event from the edit iframe's window.
           var evt = elem.contentWindow.event;
           elem.__listener.@org.ourproject.kune.platf.client.ui.rte.RichTextArea::onBrowserEvent(Lcom/google/gwt/user/client/Event;)(evt);
         }
       };

       body.onkeydown =
       body.onkeyup =
       body.onkeypress =
       body.onmousedown =
       body.onmouseup =
       body.onmousemove =
       body.onmouseover =
       body.onmouseout =
       body.onclick = handler;

       elem.contentWindow.onfocus =
       elem.contentWindow.onblur = handler;
     }-*/;

    @Override
    protected native void setTextImpl(String text) /*-{
       var elem = this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImpl::elem;
       elem.contentWindow.document.body.innerText = text;
     }-*/;

    @Override
    protected native void unhookEvents() /*-{
       var elem = this.@org.ourproject.kune.platf.client.ui.rte.impl.RichTextAreaImpl::elem;
       var body = elem.contentWindow.document.body;

       if (body) {
         // The body can be undefined in the relatively obscure case that the RTA
         // is attached and detached before it has a chance to finish initializing.
         body.onkeydown =
         body.onkeyup =
         body.onkeypress =
         body.onmousedown =
         body.onmouseup =
         body.onmousemove =
         body.onmouseover =
         body.onmouseout =
         body.onclick = null;

         elem.contentWindow.onfocus =
         elem.contentWindow.onblur = null;
       }
     }-*/;

    @Override
    boolean isRichEditingActive(Element elem) {
        return true;
    }
}