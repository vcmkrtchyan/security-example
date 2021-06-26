package org.example.security;

import java.util.*;

public class UserService {

    public static Map<String, List<String>> permissions = new HashMap<>() {{
        put("user1", Arrays.asList("/barlus", "/hajox"));
        put("user2", Collections.singletonList("/hajox"));
    }};

}
