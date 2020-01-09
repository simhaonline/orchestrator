/*
 * Copyright © 2015-2020 Santer Reply S.p.A.
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

package it.reply.orchestrator.service;

import groovy.util.ResourceException;

import it.reply.orchestrator.dal.entity.StoragePathEntity;
import it.reply.orchestrator.dal.repository.StorageRepository;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StorageServiceImpl implements StorageService {

  @Autowired
  StorageRepository storageRepository;

  @Override
  public StoragePathEntity addStoragePath(String storagePath, String template)
      throws ResourceException {
    StoragePathEntity entity = new StoragePathEntity(storagePath, template, "", "");
    if (!exists(storagePath)) {
      StoragePathEntity outEntity = storageRepository.save(entity);
      if (outEntity != null) {
        return outEntity;
      } else {
        throw new ResourceException();
      }
    }
    return null;
  }

  @Override
  public StoragePathEntity removeStoragePath(String storagePath) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean exists(String storagePath) {
    return storageRepository.findByStoragePath(storagePath) == null ? false : true;
  }

  @Override
  public List<StoragePathEntity> getStoragePathList() {
    return storageRepository.findAll();
  }

}