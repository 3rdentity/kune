/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.google.wave.splash.text;

import org.junit.Ignore;
import org.junit.Test;
import org.waveprotocol.wave.model.document.indexed.IndexedDocument;
import org.waveprotocol.wave.model.document.operation.DocInitialization;
import org.waveprotocol.wave.model.document.raw.impl.Element;
import org.waveprotocol.wave.model.document.raw.impl.Node;
import org.waveprotocol.wave.model.document.raw.impl.Text;
import org.waveprotocol.wave.model.id.IdURIEncoderDecoder;
import org.waveprotocol.wave.model.id.WaveId;
import org.waveprotocol.wave.model.id.WaveletId;
import org.waveprotocol.wave.model.version.HashedVersionFactory;
import org.waveprotocol.wave.model.version.HashedVersionZeroFactoryImpl;
import org.waveprotocol.wave.model.wave.Blip;
import org.waveprotocol.wave.model.wave.ParticipantId;
import org.waveprotocol.wave.util.escapers.jvm.JavaUrlCodec;

public class ContentNewUnrendererTest {
  private static final IdURIEncoderDecoder CODEC_URI = new IdURIEncoderDecoder(new JavaUrlCodec());
  private static final ParticipantId CREATOR = ParticipantId.ofUnsafe("someone@example.com");
  private static final HashedVersionFactory HASH_FACTORY = new HashedVersionZeroFactoryImpl(CODEC_URI);

  @Ignore
  @Test
  public void testBasicUnrender() {
    // final UnrenderedBlip result =
    // ContentUnrenderer.unrender("<p></p><p><b>Some <em>bold</em></b></p>");
    // assertEquals("", result.elements.toString());

    // final OperationSequencer<Nindo> sequencer =
    // DocProviders.createCopyingSequencer(result);
    // final CMutableDocument mutable = new
    // ContentDocument(null).createSequencedDocumentWrapper(sequencer);

    final IndexedDocument<Node, Element, Text> result = ContentNewUnrenderer.unrender("<b>Some <em>bold</em></b>");
    final DocInitialization content = result.asOperation();

    final WaveId waveId;
    final WaveletId waveletId;
    // Of just created wave
    // final WaveletName waveletName = WaveletName.of(waveId, waveletId);

    // final HashedVersionFactory hashFactory =
    // injector.getInstance(HashedVersionFactory.class);
    // final ObservableWaveletData waveletData =
    // WaveletDataUtil.createEmptyWavelet(waveletName, CREATOR,
    // HASH_FACTORY.createVersionZero(waveletName), System.currentTimeMillis());

    // final String id = "b+example";
    // // idGenerator.newBlipId() o blipId
    // final BlipData blipData = waveletData.createDocument(id, CREATOR,
    // Collections.singletonList(CREATOR), content, System.currentTimeMillis(),
    // 0);

    final Blip rootBlipId;

    // final OperationRequest operation =
    // operationRequest(OperationType.BLIP_CONTINUE_THREAD, rootBlipId,
    // Parameter.of(ParamsProperty.BLIP_DATA, blipData));

    // final WaveletName waveletName;
    // final ParticipantId participant =
    // ParticipantId.of("someone@localdomain");
    // final HashedVersion hashedVersionZero
    // = hashedVersionFactory.createVersionZero(waveletName);
    // final ObservableWaveletData createEmptyWavelet =
    // WaveletDataUtil.createEmptyWavelet(waveletName,
    // participant, hashedVersionZero, System.currentTimeMillis());
    // WaveletDataUtil.

    // WaveletDataUtil.createEmptyWavelet(null, null, null, 0)
  }
}