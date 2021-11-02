/*
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
package com.helger.rdc.core.phase4;

import javax.annotation.Nonnull;

import com.helger.phase4.crypto.AS4CryptoFactoryProperties;
import com.helger.phase4.crypto.AS4CryptoProperties;
import com.helger.phase4.crypto.IAS4CryptoFactory;
import com.helger.rdc.api.RdcConfig;

/**
 * Wrapper to access the configuration for the phase4 module. The configuration
 * file resolution resides in class {@link com.helger.rdc.api.RdcConfig.Phase4}.
 *
 * @author Philip Helger
 */
public final class Phase4Config
{
  private Phase4Config ()
  {}

  @Nonnull
  public static IAS4CryptoFactory getCryptoFactory ()
  {
    return new AS4CryptoFactoryProperties (new AS4CryptoProperties ().setKeyStoreType (RdcConfig.Phase4.getKeyStoreType ())
                                                                     .setKeyStorePath (RdcConfig.Phase4.getKeyStorePath ())
                                                                     .setKeyStorePassword (RdcConfig.Phase4.getKeyStorePassword ())
                                                                     .setKeyAlias (RdcConfig.Phase4.getKeyStoreKeyAlias ())
                                                                     .setKeyPassword (RdcConfig.Phase4.getKeyStoreKeyPassword ())
                                                                     .setTrustStoreType (RdcConfig.Phase4.getTrustStoreType ())
                                                                     .setTrustStorePath (RdcConfig.Phase4.getTrustStorePath ())
                                                                     .setTrustStorePassword (RdcConfig.Phase4.getTrustStorePassword ()));
  }
}