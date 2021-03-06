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
package com.oodlemud.appengine.counter.data.base;

import java.util.UUID;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Id;

/**
 * An abstract base class for appengine-counter entities (data stored to the
 * 
 * datastore).
 * 
 * 
 * 
 * @author David Fuelling <dfuelling@oodlemud.com>
 */
public abstract class AbstractEntity {
	@Id private String id;

	/**
	 * Default Constructor
	 */
	public AbstractEntity() {
		this(UUID.randomUUID().toString());
	}

	/**
	 * Required Params constructor
	 * 
	 * 
	 * 
	 * @param id
	 *            A globally unique identifier (i.e., a {@link UUID} as a
	 * 
	 *            String).
	 */
	public AbstractEntity(final String id) {

		this.id = id;

	}

	@java.lang.SuppressWarnings("all")
	public boolean canEqual(final java.lang.Object other) {
		return other instanceof AbstractEntity;
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public boolean equals(final java.lang.Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AbstractEntity))
			return false;
		final AbstractEntity other = (AbstractEntity) o;
		if (!other.canEqual(this))
			return false;
		final java.lang.Object this$id = this.getId();
		final java.lang.Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id))
			return false;
		return true;
	}

	@java.lang.SuppressWarnings("all")
	public String getId() {
		return this.id;
	}

	/**
	 * Assembles the Key for this entity. If an Entity has a Parent Key, that
	 * 
	 * key will be included in the returned Key heirarchy.
	 */
	public com.google.appengine.api.datastore.Key getKey() {
		final Key<?> typedKey = this.getTypedKey();
		return typedKey == null ? null : typedKey.getRaw();
	}

	/**
	 * By default, Entities have a null parent Key. This is overridden by
	 * 
	 * implementations if a Parent key exists.
	 */
	public Key<?> getParentKey() {
		return null;
	}

	/**
	 * Assembles the Key for this entity. If an Entity has a Parent Key, that
	 * 
	 * key will be included in the returned Key heirarchy.
	 * 
	 * 
	 * 
	 * @return
	 */
	public <T> Key<T> getTypedKey() {
		if (this.getId() == null) {
			return null;
		} else {
			final com.google.appengine.api.datastore.Key rawKey = ObjectifyService.factory().getMetadataForEntity(this).getKeyMetadata().getRawKey(this);
			return Key.create(rawKey);
		}
	}

	@java.lang.Override
	@java.lang.SuppressWarnings("all")
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		final java.lang.Object $id = this.getId();
		result = result * PRIME + ($id == null ? 0 : $id.hashCode());
		return result;
	}

	@java.lang.SuppressWarnings("all")
	public void setId(final String id) {
		this.id = id;
	}
}