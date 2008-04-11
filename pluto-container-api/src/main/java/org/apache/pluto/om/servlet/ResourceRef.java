/*
 * Copyright 2008 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.om.servlet;

public interface ResourceRef {

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getResRefName();

	public abstract void setResRefName(String resRefName);

	public abstract String getResType();

	public abstract void setResType(String resType);

	public abstract String getResAuth();

	public abstract void setResAuth(String resAuth);

	public abstract String getResSharingScope();

	public abstract void setResSharingScope(String resSharingScope);

}