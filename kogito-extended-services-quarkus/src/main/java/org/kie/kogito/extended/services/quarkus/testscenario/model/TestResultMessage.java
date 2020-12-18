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

import java.util.ArrayList;
import java.util.List;

public class TestResultMessage {

    private String identifier;
    private int runCount;
    private Long runTime;
    private List<TestFailure> failures = new ArrayList<>();


    public TestResultMessage() {
    }

    public TestResultMessage(String identifier,
                             int runCount,
                             long runTime,
                             List<TestFailure> failures) {
        this.identifier = identifier;
        this.runCount = runCount;
        this.runTime = runTime;
        this.failures = failures;
    }

    public boolean wasSuccessful() {
        return failures.isEmpty();
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getRunCount() {
        return runCount;
    }

    public long getRunTime() {
        return runTime;
    }

    public List<TestFailure> getFailures() {
        return failures;
    }

    public List<String> getResultStrings() {
        List<String> result = new ArrayList<>(3 + (failures == null ? 0 : failures.size()));
        result.add("RunCount: " + this.runCount);
        if (this.failures != null) {
            for (TestFailure failure : this.failures) {
                result.add("Failure: " + failure.getMessage());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "TestResultMessage{" +
                "identifier=" + identifier +
                ", runCount=" + runCount +
                ", failures=" + failures +
                '}';
    }

}
