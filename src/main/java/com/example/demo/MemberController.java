package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	@PatchMapping("/members/{id}")
	public ResponseEntity<MemberPo> updateMemberHeight(@PathVariable Long id, @RequestBody MemberPo memberReq) {
		// 查 -> 改-> 存
		Optional<MemberPo> memberPoOpt = memberRepository.findById(id);
		if (memberPoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		MemberPo memberPo = memberPoOpt.get();
		memberPo.setHeight(memberReq.getHeight());
		
		return ResponseEntity.ok(memberRepository.save(memberPo));
	}
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Void> deleteMemberById(@PathVariable Long id) {
		// 查 -> 刪除
		Optional<MemberPo> memberPoOpt = memberRepository.findById(id);
		if (memberPoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		memberRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
