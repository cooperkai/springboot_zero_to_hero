package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	private MemberRepository memberRepository;

	public MemberController(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@PostMapping("/members")
	public ResponseEntity<MemberPo> postMamber(@RequestBody MemberPo po) {
		return ResponseEntity.ok(memberRepository.save(po));
	}
}
