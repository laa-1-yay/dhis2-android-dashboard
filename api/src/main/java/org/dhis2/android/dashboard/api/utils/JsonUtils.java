/*
 * Copyright (c) 2015, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.dhis2.android.dashboard.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

/**
 * Created by araz on 02.05.2015.
 */
public final class JsonUtils {
    private static final String EMPTY_FIELD = "";

    public static <T> T fromJson(String content, TypeReference<T> typeReference) {
        if (content != null) {
            try {
                return JsonMapperProvider.getInstance()
                        .readValue(content, typeReference);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T fromJson(String source, Class<T> clazz) {
        if (source != null) {
            try {
                return JsonMapperProvider.getInstance()
                        .readValue(source, clazz);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static <T> String toJson(T object) {
        if (object != null) {
            try {
                return JsonMapperProvider.getInstance()
                        .writeValueAsString(object);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return EMPTY_FIELD;
    }
}
