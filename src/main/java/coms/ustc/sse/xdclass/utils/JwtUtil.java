package coms.ustc.sse.xdclass.utils;

import coms.ustc.sse.xdclass.controller.UserController;
import coms.ustc.sse.xdclass.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {


    private static final String TOKEN_PREFIX = "ustc";
    private static final String SECRET = "abc123";
    private static final long EXPIRE = 60 * 1000 * 60 * 24 * 7;// 7填
    /**
     * 指明谁颁布的
     */
    private static final String SUBJECT = "gzr";

    /**
     * 根据⽤户信息，⽣成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim(UserController.USER_ID,user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +
                        EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的⽅法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
