package org.example.controller;

import org.example.model.dtos.MembersDTO;
import org.example.service.MembersService;
import org.example.service.mapper.MembersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/members")
public class MembersController {
    private final MembersService membersService;
    private final MembersMapper membersMapper;

    @Autowired
    MembersController(MembersService membersService, MembersMapper membersMapper) {
        this.membersService = membersService;
        this.membersMapper = membersMapper;
    }

    @GetMapping
    public ResponseEntity<List<MembersDTO>> getMembers() {
        return new ResponseEntity<>(membersService.getAllMembers().stream().map(x -> membersMapper.toDTO(Objects.requireNonNull(x))).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MembersDTO> getMember(@PathVariable UUID id) {
        return new ResponseEntity<>(membersMapper.toDTO(Objects.requireNonNull(membersService.getMember(id).orElse(null))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MembersDTO> postMember(@RequestBody MembersDTO membersDTO) {
        membersService.createMember(membersMapper.toEntity(membersDTO));
        return  new ResponseEntity<>(membersDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMember(@PathVariable UUID id){
        membersService.deleteMember(id);
    }

    @PutMapping
    public ResponseEntity<MembersDTO> editMember(@RequestBody MembersDTO membersDTO){
        membersService.updateMember(membersMapper.toEntity(membersDTO));
        return  new ResponseEntity<>(membersDTO, HttpStatus.OK);
    }
}
