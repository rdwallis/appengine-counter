// Generated by delombok at Sat Nov 30 16:34:14 CAT 2013
/**
 * Copyright (C) 2013 Oodlemud Inc. (developers@oodlemud.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.oodlemud.appengine.counter;

import lombok.NonNull;

import com.oodlemud.appengine.counter.data.CounterData;
import com.oodlemud.appengine.counter.data.CounterData.CounterStatus;

public class CounterBuilder {
	public static final Counter zero(final String counterName) {
		return new CounterBuilder(counterName).build();
	}

	@NonNull private final String counterName;
	private CounterStatus counterStatus = CounterStatus.AVAILABLE;

	private long count;

	/**
	 * Build method for constructing a new Counter.
	 * 
	 * 
	 * 
	 * @param builder
	 * 
	 * @return
	 */
	public CounterBuilder(final CounterData counterData) {

		this.counterName = counterData.getCounterName();
		this.counterStatus = counterData.getCounterStatus();
	}

	@java.beans.ConstructorProperties({ "counterName" })
	@java.lang.SuppressWarnings("all")
	public CounterBuilder(@NonNull final String counterName) {

		if (counterName == null) {
			throw new java.lang.NullPointerException("counterName");
		}
		this.counterName = counterName;
	}

	/**
	 * Build method for constructing a new Counter.
	 * 
	 * 
	 * 
	 * @param builder
	 * 
	 * @return
	 */
	public Counter build() {
		return new Counter(this.getCounterName(), this.getCounterStatus(), this.getCount());
	}

	@java.lang.SuppressWarnings("all")
	public boolean canEqual(final java.lang.Object other) {
		return other instanceof CounterBuilder;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CounterBuilder))
			return false;
		final CounterBuilder other = (CounterBuilder) o;
		if (!other.canEqual(this))
			return false;
		final java.lang.Object this$counterName = this.getCounterName();
		final java.lang.Object other$counterName = other.getCounterName();
		if (this$counterName == null ? other$counterName != null : !this$counterName.equals(other$counterName))
			return false;
		final java.lang.Object this$counterStatus = this.getCounterStatus();
		final java.lang.Object other$counterStatus = other.getCounterStatus();
		if (this$counterStatus == null ? other$counterStatus != null : !this$counterStatus.equals(other$counterStatus))
			return false;
		if (this.getCount() != other.getCount())
			return false;
		return true;
	}

	@java.lang.SuppressWarnings("all")
	public long getCount() {
		return this.count;
	}

	@NonNull
	@java.lang.SuppressWarnings("all")
	public String getCounterName() {
		return this.counterName;
	}

	@java.lang.SuppressWarnings("all")
	public CounterStatus getCounterStatus() {
		return this.counterStatus;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		final java.lang.Object $counterName = this.getCounterName();
		result = result * PRIME + ($counterName == null ? 0 : $counterName.hashCode());
		final java.lang.Object $counterStatus = this.getCounterStatus();
		result = result * PRIME + ($counterStatus == null ? 0 : $counterStatus.hashCode());
		final long $count = this.getCount();
		result = result * PRIME + (int) ($count >>> 32 ^ $count);
		return result;
	}

	@java.lang.SuppressWarnings("all")
	public void setCount(final long count) {
		this.count = count;
	}

	@java.lang.SuppressWarnings("all")
	public void setCounterStatus(final CounterStatus counterStatus) {
		this.counterStatus = counterStatus;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "CounterBuilder(counterName=" + this.getCounterName() + ", counterStatus=" + this.getCounterStatus() + ", count=" + this.getCount() + ")";
	}

	/**
	 * @param count
	 * 
	 * @return
	 */
	public CounterBuilder withCount(final long count) {
		this.setCount(count);
		return this;
	}

	/**
	 * @param counterStatus
	 * 
	 * @return
	 */
	public CounterBuilder withCounterStatus(final CounterStatus counterStatus) {
		this.setCounterStatus(counterStatus);
		return this;
	}
}