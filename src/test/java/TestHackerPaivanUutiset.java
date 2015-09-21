/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asjuvone
 */
public class TestHackerPaivanUutiset {
    
    //public static WireMockServer wireMockServer;
    //public static final String NEWSTORIES = "[10251637,10250803,10250599,10250770,10249362,10250125,10251703,10250558,10250085,10250708,10251369,10250271,10249602,10250248,10249079,10249962,10251263,10250665,10250120,10248773,10250002,10250680,10250489,10249820,10250009,10251143,10249492,10249251,10250302,10249167,10250336,10248151,10248937,10249554,10250097,10248084,10250517,10251352,10248556,10249597,10249139,10250077,10249536,10250232,10248449,10250545,10250132,10247589,10249778,10250378,10249495,10247880,10250288,10247943,10248273,10248756,10248763,10251166,10250115,10250371,10248191,10249372,10248651,10249336,10250071,10251313,10250035,10247289,10248465,10248309,10247329,10248411,10249032,10245836,10249887,10244950,10249899,10247255,10247497,10246656,10247426,10248566,10247496,10249509,10246697,10246593,10247910,10247471,10246484,10245928,10247574,10249946,10248552,10246600,10248623,10249238,10248203,10248588,10247688,10248423,10247307,10248528,10246596,10248845,10249308,10246003,10248676,10246967,10250112,10248459,10248132,10249334,10249935,10250547,10237786,10246963,10243823,10245960,10245033,10244771,10245416,10248116,10245490,10245653,10246705,10250017,10247543,10244619,10246131,10247980,10244944,10246739,10245963,10248414,10247592,10249063,10248690,10250033,10249364,10244532,10247544,10247127,10244764,10247968,10246040,10245542,10245199,10244653,10245673,10246576,10246053,10246644,10246429,10245556,10240001,10246615,10247704,10245805,10244398,10247299,10247487,10247994,10246035,10246514,10244999,10249078,10239962,10248519,10245458,10240295,10233339,10237977,10244622,10249478,10246575,10247064,10248023,10231237,10248954,10247212,10248522,10247430,10246310,10236871,10244353,10242850,10247904,10250124,10237697,10224639,10238062,10249029,10243101,10244566,10244129,10245102,10244284,10246776,10242645,10245830,10245277,10246196,10245156,10246114,10245991,10246216,10246603,10222590,10247520,10234435,10241731,10239863,10246177,10246161,10245012,10245032,10244094,10247416,10247884,10246069,10245257,10247436,10241398,10246632,10246789,10246620,10245665,10245214,10245307,10246538,10243403,10245323,10234287,10244672,10243151,10243873,10244726,10247045,10244883,10246473,10246501,10244340,10246964,10243720,10245183,10240957,10238797,10244603,10238528,10242489,10246401,10239043,10246356,10244335,10240420,10236668,10242662,10243533,10243794,10244248,10245275,10241332,10239413,10246997,10235582,10248142,10246011,10244714,10241595,10236057,10243105,10238387,10239922,10241177,10240397,10241491,10243217,10244849,10244642,10242987,10246913,10247065,10243263,10237805,10241805,10245061,10245485,10240345,10243364,10246292,10239744,10242896,10246874,10245737,10245778,10229009,10246610,10244964,10244397,10246678,10246245,10244868,10245279,10242920,10243661,10243317,10243011,10243645,10244295,10244525,10246407,10245687,10244282,10244087,10247764,10245538,10231907,10239008,10245692,10240408,10247405,10226607,10246042,10238132,10243665,10243075,10244179,10243868,10245706,10245040,10245694,10233367,10239256,10238327,10243163,10242678,10244832,10237195,10243890,10235072,10241431,10233682,10241600,10240991,10235734,10238109,10229937,10244739,10240327,10235974,10240206,10238791,10238826,10238398,10237975,10232395,10243561,10238312,10238869,10232595,10238315,10234620,10234784,10228632,10227224,10224547,10242524,10235844,10223446,10226196,10246337,10226236,10246428,10251181,10251293,10249526,10242742,10243439,10238112,10237501,10238295,10242787,10238875,10241829,10241665,10242950,10240296,10238934,10236916,10233464,10243198,10238242,10237636,10241906,10232769,10238156,10237262,10241119,10239931,10240342,10244088,10239086,10240387,10240430,10243420,10238373,10235839,10237902,10243849,10238959,10243514,10237793,10233662,10238965,10240734,10233364,10243123,10240594,10237252,10241986,10243701,10243663,10238089,10237669,10238690,10232025,10231967,10241156,10239893,10240223,10240566,10231651,10243228,10232523,10243174,10237042,10242598,10239232,10242407,10240858,10238390,10233555,10242591,10230937,10242182,10241897,10239732,10242902,10238992,10235757,10237804,10235554,10234849,10238379,10238164,10238297,10237345,10239818,10236896,10231049,10232690,10234623,10237877,10237217,10235323,10241342,10238521,10235806,10230964,10233457,10231945,10232737,10235623,10235171,10236227,10239624,10238039,10227198,10235722,10232648,10235032,10226513,10236691,10238936,10239285,10224622,10225867,10234809,10237663,10235688,10232518,10233013,10235377,10237869,10234458,10227000,10237113,10237974,10237953,10238681]";
    
    
    public TestHackerPaivanUutiset() {
        wireMockServer = new WireMockServer(); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        wireMockServer.stubFor(get(urlEqualTo("*"))
            .willReturn(aResponse()
                .withStatus(200)
                .withBody(NEWSTORIES)));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        wireMockServer.start();
    }
    
    @After
    public void tearDown() {
        wireMockServer.stop();
    }

    @Test
    public void testHaeSuosituinUutinen() {
        String s = HackerPaivanUutiset.haeSuosituinUutinen();
    }
}
