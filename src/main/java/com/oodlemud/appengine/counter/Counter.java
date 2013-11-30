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

import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Preconditions;
import com.oodlemud.appengine.counter.data.CounterData.CounterStatus;

/**
 * An immutable object that stores count information.
 *
 * @author David Fuelling <dfuelling@oodlemud.com>
 */
public class Counter {
	private final String counterName;
	private final CounterStatus counterStatus;
	private final long count;
	
	/**
	 * Required-args Constructor. Sets the {@code counterStatus} to
	 * {@link CounterStatus.AVAILABLE} and the {@code count} to zero.
	 *
	 * @param counterName
	 */
	public Counter(final String counterName) {
		this(counterName, CounterStatus.AVAILABLE);
	}
	
	/**
	 * Required-args Constructor. Sets the {@code count} to zero.
	 *
	 * @param counterName
	 * @param counterStatus
	 */
	public Counter(final String counterName, final CounterStatus counterStatus) {
		this(counterName, counterStatus, 0);
	}
	
	/**
	 * Required-args Constructor.
	 *
	 * @param counterName
	 * @param counterStatus
	 * @param count
	 */
	public Counter(final String counterName, final CounterStatus counterStatus, final long count) {
		
		Preconditions.checkArgument(!StringUtils.isBlank(counterName), "CounterName may not be empty, blank, or null!");
		Preconditions.checkNotNull(counterStatus);
		this.counterName = counterName;
		this.counterStatus = counterStatus;
		this.count = count;
	}
	
	@java.lang.SuppressWarnings("all")
	public String getCounterName() {
		return this.counterName;
	}
	
	@java.lang.SuppressWarnings("all")
	public CounterStatus getCounterStatus() {
		return this.counterStatus;
	}
	
	@java.lang.SuppressWarnings("all")
	public long getCount() {
		return this.count;
	}
	
	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this) return true;
		if (!(o instanceof Counter)) return false;
		final Counter other = (Counter)o;
		if (!other.canEqual((java.lang.Object)this)) return false;
		final java.lang.Object this$counterName = this.getCounterName();
		final java.lang.Object other$counterName = other.getCounterName();
		if (this$counterName == null ? other$counterName != null : !this$counterName.equals(other$counterName)) return false;
		final java.lang.Object this$counterStatus = this.getCounterStatus();
		final java.lang.Object other$counterStatus = other.getCounterStatus();
		if (this$counterStatus == null ? other$counterStatus != null : !this$counterStatus.equals(other$counterStatus)) return false;
		if (this.getCount() != other.getCount()) return false;
		return true;
	}
	
	@java.lang.SuppressWarnings("all")
	public boolean canEqual(final java.lang.Object other) {
		return other instanceof Counter;
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
		result = result * PRIME + (int)($count >>> 32 ^ $count);
		return result;
	}
	
	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "Counter(counterName=" + this.getCounterName() + ", counterStatus=" + this.getCounterStatus() + ", count=" + this.getCount() + ")";
	}
}