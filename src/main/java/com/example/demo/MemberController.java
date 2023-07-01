package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/members")
	public ResponseEntity<List<MemberPo>> findAllMambers() {
		return ResponseEntity.ok(memberRepository.findAll());
	}

	@GetMapping("/members/{id}")
	public ResponseEntity<MemberPo> findMambersById(@PathVariable Long id) {
		Optional<MemberPo> memberPoOpt = memberRepository.findById(id);
		if (memberPoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(memberPoOpt.get());
		}
	}
}
