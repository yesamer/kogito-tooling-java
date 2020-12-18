/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
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
package org.kie.kogito.extended.services.quarkus.testscenario.model;

import java.util.List;

import org.drools.scenariosimulation.api.model.BackgroundDataWithIndex;
import org.drools.scenariosimulation.api.model.ScenarioWithIndex;
import org.drools.scenariosimulation.api.model.SimulationRunMetadata;

public class TestScenarioRunResult {

    private List<ScenarioWithIndex> scenarioWithIndex;

    private List<BackgroundDataWithIndex> backgroundDataWithIndex;

    private SimulationRunMetadata simulationRunMetadata;

    public TestScenarioRunResult(List<ScenarioWithIndex> scenarioWithIndex, List<BackgroundDataWithIndex> backgroundDataWithIndex, SimulationRunMetadata simulationRunMetadata) {
        this.scenarioWithIndex = scenarioWithIndex;
        this.backgroundDataWithIndex = backgroundDataWithIndex;
        this.simulationRunMetadata = simulationRunMetadata;
    }

    public List<ScenarioWithIndex> getScenarioWithIndex() {
        return scenarioWithIndex;
    }

    public void setScenarioWithIndex(List<ScenarioWithIndex> scenarioWithIndex) {
        this.scenarioWithIndex = scenarioWithIndex;
    }

    public List<BackgroundDataWithIndex> getBackgroundDataWithIndex() {
        return backgroundDataWithIndex;
    }

    public void setBackgroundDataWithIndex(List<BackgroundDataWithIndex> backgroundDataWithIndex) {
        this.backgroundDataWithIndex = backgroundDataWithIndex;
    }

    public SimulationRunMetadata getSimulationRunMetadata() {
        return simulationRunMetadata;
    }

    public void setSimulationRunMetadata(SimulationRunMetadata simulationRunMetadata) {
        this.simulationRunMetadata = simulationRunMetadata;
    }
}
