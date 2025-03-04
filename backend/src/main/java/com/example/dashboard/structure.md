Structure of JWT and OAuth

📂 src/main/java/com/example/dashboard
├── 📂 config
│   ├── SecurityConfig.java         # Spring Security 및 JWT, OAuth 보안 설정
│   ├── JwtAuthFilter.java          # JWT 검증 필터
│   ├── OAuth2Config.java           # OAuth2 인증 설정 (Google, GitHub 등)
│   ├── CorsConfig.java             # CORS 설정
│   ├── JwtUtil.java                # JWT 토큰 생성 및 검증 유틸리티
│   ├── CustomOAuth2UserService.java # OAuth2 사용자 정보 처리
│   ├── CustomUserDetailsService.java # 로그인 시 사용자 정보 조회
│
├── 📂 controller
│   ├── AuthController.java         # 로그인 및 JWT 발급 API
│   ├── UserController.java         # 사용자 정보 API
│   ├── DashboardController.java    # 대시보드 관련 API
│
├── 📂 service
│   ├── UserService.java            # 사용자 관련 로직 처리
│
├── 📂 repository
│   ├── UserRepository.java         # 사용자 데이터베이스 관리
│
├── 📂 model
│   ├── User.java                   # 사용자 엔티티
│   ├── Role.java                   # 사용자 역할 (USER, ADMIN)
│
├── 📂 dto
│   ├── LoginRequest.java           # 로그인 요청 DTO
│   ├── SignUpRequest.java          # 회원가입 요청 DTO
│   ├── UserResponse.java           # 사용자 응답 DTO
│
├── 📂 exception
│   ├── CustomException.java        # 커스텀 예외 처리
│
├── 📂 utils
│   ├── PasswordEncoderUtil.java    # 비밀번호 암호화 유틸리티
│
├── Application.java                 # Spring Boot 메인 실행 파일