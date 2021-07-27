/**
 * Copyright (C) 2021 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
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
package com.helger.rdc.webapi;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.photon.api.APIDescriptor;
import com.helger.photon.api.APIPath;
import com.helger.photon.api.IAPIRegistry;
import com.helger.rdc.webapi.as4.ApiPostSend;
import com.helger.rdc.webapi.smp.ApiGetSmpDocTypes;
import com.helger.rdc.webapi.smp.ApiGetSmpEndpoints;
import com.helger.rdc.webapi.user.ApiPostUserSubmitEdm;
import com.helger.rdc.webapi.validation.ApiPostValidateIem;

/**
 * Register all APIs
 *
 * @author Philip Helger
 */
@Immutable
public final class RDCAPIInit
{
  private RDCAPIInit ()
  {}

  public static void initAPI (@Nonnull final IAPIRegistry aAPIRegistry)
  {
    // SMP stuff
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.get ("/smp/doctypes/{pid}"), ApiGetSmpDocTypes.class));
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.get ("/smp/endpoints/{pid}/{doctypeid}"),
                                                 ApiGetSmpEndpoints.class));

    // Validation stuff
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.post ("/validate/request"),
                                                 new ApiPostValidateIem (ERDCIemType.REQUEST)));
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.post ("/validate/response"),
                                                 new ApiPostValidateIem (ERDCIemType.RESPONSE)));

    // AS4 stuff
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.post ("/send"), ApiPostSend.class));

    // User stuff
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.post ("/user/submit/request"),
                                                 new ApiPostUserSubmitEdm (ERDCIemType.REQUEST)));
    aAPIRegistry.registerAPI (new APIDescriptor (APIPath.post ("/user/submit/response"),
                                                 new ApiPostUserSubmitEdm (ERDCIemType.RESPONSE)));
  }
}