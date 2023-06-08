/*
 * Copyright 2019 Hippo Seven
 * Copyright 2023-Present Shiqi Mei
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

package com.shiqi.quickjs;

final class JSInt extends JSNumber {

  private final int value;

  JSInt(long pointer, JSContext jsContext, int value) {
    super(pointer, jsContext);
    this.value = value;
  }

  private int getIntInRange(String javaType, int min, int max) {
    int value = this.value;
    if (min <= value && value <= max) {
      return value;
    } else {
      throw new JSDataException("Can't treat " + value + " as " + javaType);
    }
  }

  @Override
  public byte getByte() {
    return (byte) getIntInRange("byte", Byte.MIN_VALUE, Byte.MAX_VALUE);
  }

  @Override
  public short getShort() {
    return (short) getIntInRange("short", Short.MIN_VALUE, Short.MAX_VALUE);
  }

  @Override
  public int getInt() {
    return value;
  }

  @Override
  public long getLong() {
    return value;
  }

  @Override
  public float getFloat() {
    return value;
  }

  @Override
  public double getDouble() {
    return value;
  }
}