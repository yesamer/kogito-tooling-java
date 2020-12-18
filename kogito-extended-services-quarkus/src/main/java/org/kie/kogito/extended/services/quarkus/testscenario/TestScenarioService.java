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
package org.kie.kogito.extended.services.quarkus.testscenario;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.drools.scenariosimulation.api.model.Background;
import org.drools.scenariosimulation.api.model.ScenarioWithIndex;
import org.drools.scenariosimulation.api.model.ScesimModelDescriptor;
import org.drools.scenariosimulation.api.model.Settings;
import org.drools.scenariosimulation.backend.runner.AbstractScenarioRunner;
import org.drools.scenariosimulation.backend.runner.model.ScenarioRunnerDTO;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.kie.kogito.extended.services.quarkus.testscenario.model.TestScenarioRunResult;
import org.kogito.scenariosimulation.runner.KogitoDMNScenarioRunner;

@ApplicationScoped
public class TestScenarioService {

    public TestScenarioRunResult runTest(final String identifier,
                                         final ScesimModelDescriptor simulationDescriptor,
                                         final List<ScenarioWithIndex> scenarios,
                                         final Settings settings,
                                         final Background background) {

        final ScenarioRunnerDTO scenarioRunnerDTO = new ScenarioRunnerDTO(simulationDescriptor, scenarios, null, settings, background);
        final AbstractScenarioRunner scenarioRunner = new KogitoDMNScenarioRunner(scenarioRunnerDTO);
        final Result result = new JUnitCore().run(scenarioRunner);

        return new TestScenarioRunResult(scenarios,
                                         background.getBackgroundDataWithIndex(),
                                         scenarioRunner.getLastRunResultMetadata().orElseThrow(
                                                 () -> new IllegalStateException("SimulationRunMetadata should be available after a run")));
    }
}
