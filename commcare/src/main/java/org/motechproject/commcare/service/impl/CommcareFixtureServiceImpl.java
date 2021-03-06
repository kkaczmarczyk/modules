package org.motechproject.commcare.service.impl;

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import org.motechproject.commcare.domain.CommcareFixture;
import org.motechproject.commcare.domain.CommcareFixturesJson;
import org.motechproject.commcare.service.CommcareFixtureService;
import org.motechproject.commcare.client.CommCareAPIHttpClient;
import org.motechproject.commons.api.json.MotechJsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CommcareFixtureServiceImpl implements CommcareFixtureService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MotechJsonReader motechJsonReader;

    private CommCareAPIHttpClient commcareHttpClient;

    @Autowired
    public CommcareFixtureServiceImpl(CommCareAPIHttpClient commcareHttpClient) {
        this.commcareHttpClient = commcareHttpClient;
        this.motechJsonReader = new MotechJsonReader();
    }

    @Override
    public List<CommcareFixture> getFixtures(Integer pageSize, Integer pageNumber) {
        String response = commcareHttpClient.fixturesRequest(pageSize, pageNumber);
        Type commcareFixtureType = new TypeToken<CommcareFixturesJson>() { } .getType();
        CommcareFixturesJson allFixtures = (CommcareFixturesJson) motechJsonReader.readFromString(response, commcareFixtureType);

        return allFixtures.getObjects();

    }

    @Override
    public CommcareFixture getCommcareFixtureById(String id) {
        String returnJson = commcareHttpClient.fixtureRequest(id);

        Type commcareFixtureType = new TypeToken<CommcareFixture>() { } .getType();
        CommcareFixture fixture = null;

        try {
            fixture = (CommcareFixture) motechJsonReader.readFromString(returnJson, commcareFixtureType);
        } catch (JsonParseException e) {
            logger.info("Unable to parse JSON from Commcare: " + returnJson);
        }

        return fixture;
    }
}
