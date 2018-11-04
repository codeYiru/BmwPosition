package com.vehicle.position;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vehicle.position.entities.VehicleUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private MockHttpSession session;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		session = new MockHttpSession();
		VehicleUser vUser = new VehicleUser("root", "root");
		session.setAttribute("user", vUser);
	}

	// @Test
	public void addOne() throws Exception {
		String json = "{\"session\":\"abced\", \"timestamp\":1234567890, \"latitude\": 123.56, \"longtitude\": 30.33, \"heading\":1}";

		mockMvc.perform(MockMvcRequestBuilders.post("/Save/save").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(json.getBytes()) // 传json参数
				.session(session)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void addBatch() throws Exception {
		int N = 10;
		StringBuilder builder = new StringBuilder();
		String[] sArr = new String[] { "abcdef", "abc123" };
		builder.append("[");

		long timestamp = 1541078739600l;
		double latitude = 123.56;
		double longtitude = 30.33;
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int select = i % 2;
			String session = sArr[select];

			timestamp = (long) (Math.random() * N * 100) + timestamp;
			latitude = Math.random() + latitude;
			longtitude = Math.random() + longtitude;
			String tmp = "{\"session\":\"" + session + "\",\"timestamp\":" + timestamp + ",\"latitude\":" + latitude
					+ ",\"longtitude\":" + longtitude + ",\"heading\":" + select + "}";

			strList.add(tmp);
		}
		builder.append(String.join(",", strList));
		builder.append("]");
		String json = builder.toString();
		 System.out.println(json);

		mockMvc.perform(MockMvcRequestBuilders.post("/Save/saveBatch").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(json.getBytes()).session(session))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

	}

}
