package com.example.spotit;

public class VoiceApp {


    const fetch = require("node-fetch");

const resp = await fetch(`https://calling-use1.api.sinch.com/v1/callouts/`, {
            method: "POST",
                         headers: {
        "Content-Type": "application/json",
                Authorization:
        "Basic " + Buffer.from("<username>:<password>").toString("base64"),
    },
    body: JSON.stringify({
        method: "ttsCallout",
                ttsCallout: {
            cli: "14155552223333",
                    destination: {
                type: "number",
                        number: "+14045555000",
            },
            domain: "pstn",
                    custom: "customData",
                    locale: "en-US",
                    prompts: "This is a phone call from Sinch",
        },
    }),
});

        const data = await resp.json();
        console.log(data);
}
