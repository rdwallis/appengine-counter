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
package com.oodlemud.appengine.counter.service;

import com.google.appengine.api.memcache.Expiration;
import com.google.common.base.Preconditions;
import com.oodlemud.annotations.Immutable;

/**
 * A Configuration class for {@link ShardedCounterService}.
 *
 * @author David Fuelling <dfuelling@oodlemud.com>
 */
@Immutable
public class ShardedCounterServiceConfiguration {
	// The number of shards to begin with for this counter.
	static final int DEFAULT_NUM_COUNTER_SHARDS = 3;
	static final int SIXTY_MINUTES_IN_SECONDS = 60 * 60;
	// 5 Minute Expiration (by default) for counter counts in memcache before a
	// Datastore query is attempted to get the new count.
	static final Expiration DEFAULT_EXPIRATION = Expiration.byDeltaSeconds(SIXTY_MINUTES_IN_SECONDS);
	// The number of counter shards to create when a new counter is created. The
	// default value is 3.
	private final int numInitialShards;
	// The default Memcache expiration for counter objects.
	private final Expiration defaultExpiration;
	// The name of the queue that will be used to delete shards in an async
	// fashion
	private final String deleteCounterShardQueueName;
	// The optional value of {@link TaskBuilder#url} when interacting with the
	// queue used to delete CounterShards.
	private final String relativeUrlPathForDeleteTaskQueue;
	
	/**
	 * The default constructor for building a ShardedCounterService
	 * configuration class. Private so that only the builder can build this
	 * class.
	 *
	 * @param builder
	 */
	private ShardedCounterServiceConfiguration(Builder builder) {
		
		Preconditions.checkNotNull(builder);
		this.numInitialShards = builder.numInitialShards;
		this.deleteCounterShardQueueName = builder.deleteCounterShardQueueName;
		this.relativeUrlPathForDeleteTaskQueue = builder.relativeUrlPathForDeleteTaskQueue;
		this.defaultExpiration = builder.getDefaultExpiration();
	}
	
	/**
	 * Constructs a {@link ShardedCounterServiceConfiguration} object with
	 * default values.
	 *
	 * @return
	 */
	public static ShardedCounterServiceConfiguration defaultConfiguration() {
		ShardedCounterServiceConfiguration.Builder builder = new ShardedCounterServiceConfiguration.Builder();
		return new ShardedCounterServiceConfiguration(builder);
	}
	
	/**
	 * A Builder for {@link ShardedCounterServiceConfiguration}.
	 *
	 * @author david
	 */
	public static final class Builder {
		private int numInitialShards;
		/**
		 * Note: {@code null} may be used here to specify no specific
		 * expiration.
		 */
		private Expiration defaultExpiration;
		private String deleteCounterShardQueueName;
		private String relativeUrlPathForDeleteTaskQueue;
		/**
		 * Default Constructor. Sets up this buildr with 1 shard by default.
		 */
		public Builder() {
			
			this.numInitialShards = DEFAULT_NUM_COUNTER_SHARDS;
			this.defaultExpiration = DEFAULT_EXPIRATION;
		}
		
		public Builder withNumInitialShards(int numInitialShards) {
			Preconditions.checkArgument(numInitialShards > 0, "Number of Shards for a new CounterData must be greater than 0!");
			this.numInitialShards = numInitialShards;
			return this;
		}
		
		public Builder withDeleteCounterShardQueueName(String deleteCounterShardQueueName) {
			this.deleteCounterShardQueueName = deleteCounterShardQueueName;
			return this;
		}
		
		public Builder withRelativeUrlPathForDeleteTaskQueue(String relativeUrlPathForDeleteTaskQueue) {
			this.relativeUrlPathForDeleteTaskQueue = relativeUrlPathForDeleteTaskQueue;
			return this;
		}
		/**
		 * Method to build a new {@link ShardedCounterServiceConfiguration}.
		 * 
		 * @return
		 */
		public ShardedCounterServiceConfiguration build() {
			return new ShardedCounterServiceConfiguration(this);
		}
		
		@java.lang.SuppressWarnings("all")
		public int getNumInitialShards() {
			return this.numInitialShards;
		}
		
		@java.lang.SuppressWarnings("all")
		public void setNumInitialShards(final int numInitialShards) {
			this.numInitialShards = numInitialShards;
		}
		
		@java.lang.SuppressWarnings("all")
		public Expiration getDefaultExpiration() {
			return this.defaultExpiration;
		}
		
		@java.lang.SuppressWarnings("all")
		public void setDefaultExpiration(final Expiration defaultExpiration) {
			this.defaultExpiration = defaultExpiration;
		}
		
		@java.lang.SuppressWarnings("all")
		public String getDeleteCounterShardQueueName() {
			return this.deleteCounterShardQueueName;
		}
		
		@java.lang.SuppressWarnings("all")
		public void setDeleteCounterShardQueueName(final String deleteCounterShardQueueName) {
			this.deleteCounterShardQueueName = deleteCounterShardQueueName;
		}
		
		@java.lang.SuppressWarnings("all")
		public String getRelativeUrlPathForDeleteTaskQueue() {
			return this.relativeUrlPathForDeleteTaskQueue;
		}
		
		@java.lang.SuppressWarnings("all")
		public void setRelativeUrlPathForDeleteTaskQueue(final String relativeUrlPathForDeleteTaskQueue) {
			this.relativeUrlPathForDeleteTaskQueue = relativeUrlPathForDeleteTaskQueue;
		}
	}
	
	@java.lang.SuppressWarnings("all")
	public int getNumInitialShards() {
		return this.numInitialShards;
	}
	
	@java.lang.SuppressWarnings("all")
	public Expiration getDefaultExpiration() {
		return this.defaultExpiration;
	}
	
	@java.lang.SuppressWarnings("all")
	public String getDeleteCounterShardQueueName() {
		return this.deleteCounterShardQueueName;
	}
	
	@java.lang.SuppressWarnings("all")
	public String getRelativeUrlPathForDeleteTaskQueue() {
		return this.relativeUrlPathForDeleteTaskQueue;
	}
	
	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public java.lang.String toString() {
		return "ShardedCounterServiceConfiguration(numInitialShards=" + this.getNumInitialShards() + ", defaultExpiration=" + this.getDefaultExpiration() + ", deleteCounterShardQueueName=" + this.getDeleteCounterShardQueueName() + ", relativeUrlPathForDeleteTaskQueue=" + this.getRelativeUrlPathForDeleteTaskQueue() + ")";
	}
	
	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this) return true;
		if (!(o instanceof ShardedCounterServiceConfiguration)) return false;
		final ShardedCounterServiceConfiguration other = (ShardedCounterServiceConfiguration)o;
		if (!other.canEqual((java.lang.Object)this)) return false;
		if (this.getNumInitialShards() != other.getNumInitialShards()) return false;
		final java.lang.Object this$defaultExpiration = this.getDefaultExpiration();
		final java.lang.Object other$defaultExpiration = other.getDefaultExpiration();
		if (this$defaultExpiration == null ? other$defaultExpiration != null : !this$defaultExpiration.equals(other$defaultExpiration)) return false;
		final java.lang.Object this$deleteCounterShardQueueName = this.getDeleteCounterShardQueueName();
		final java.lang.Object other$deleteCounterShardQueueName = other.getDeleteCounterShardQueueName();
		if (this$deleteCounterShardQueueName == null ? other$deleteCounterShardQueueName != null : !this$deleteCounterShardQueueName.equals(other$deleteCounterShardQueueName)) return false;
		final java.lang.Object this$relativeUrlPathForDeleteTaskQueue = this.getRelativeUrlPathForDeleteTaskQueue();
		final java.lang.Object other$relativeUrlPathForDeleteTaskQueue = other.getRelativeUrlPathForDeleteTaskQueue();
		if (this$relativeUrlPathForDeleteTaskQueue == null ? other$relativeUrlPathForDeleteTaskQueue != null : !this$relativeUrlPathForDeleteTaskQueue.equals(other$relativeUrlPathForDeleteTaskQueue)) return false;
		return true;
	}
	
	@java.lang.SuppressWarnings("all")
	public boolean canEqual(final java.lang.Object other) {
		return other instanceof ShardedCounterServiceConfiguration;
	}
	
	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + this.getNumInitialShards();
		final java.lang.Object $defaultExpiration = this.getDefaultExpiration();
		result = result * PRIME + ($defaultExpiration == null ? 0 : $defaultExpiration.hashCode());
		final java.lang.Object $deleteCounterShardQueueName = this.getDeleteCounterShardQueueName();
		result = result * PRIME + ($deleteCounterShardQueueName == null ? 0 : $deleteCounterShardQueueName.hashCode());
		final java.lang.Object $relativeUrlPathForDeleteTaskQueue = this.getRelativeUrlPathForDeleteTaskQueue();
		result = result * PRIME + ($relativeUrlPathForDeleteTaskQueue == null ? 0 : $relativeUrlPathForDeleteTaskQueue.hashCode());
		return result;
	}
}