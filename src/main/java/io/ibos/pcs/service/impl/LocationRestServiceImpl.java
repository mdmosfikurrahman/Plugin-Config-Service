package io.ibos.pcs.service.impl;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazilaResponse;
import io.ibos.pcs.repository.DistrictRepository;
import io.ibos.pcs.repository.DivisionRepository;
import io.ibos.pcs.repository.UpazilaRepository;
import io.ibos.pcs.service.LocationRestService;
import io.ibos.pcs.util.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationRestServiceImpl implements LocationRestService {

    private final DivisionRepository divisionRepository;
    private final DistrictRepository districtRepository;
    private final UpazilaRepository upazilaRepository;
    private final LocationMapper locationMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DivisionResponse> getDivisions() {
        return divisionRepository.findAll()
                .stream()
                .map(locationMapper::toDivisionResponse)
                .toList();
    }

    @Override
    public List<DistrictResponse> getDistricts() {
        return districtRepository.findAll()
                .stream()
                .map(locationMapper::toDistrictResponse)
                .toList();
    }

    @Override
    public List<UpazilaResponse> getUpazilas() {
        return upazilaRepository.findAll()
                .stream()
                .map(locationMapper::toUpazilaResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DistrictResponse> getDistrictsByDivisionId(Long divisionId) {
        return districtRepository.findByDivision_Id(divisionId)
                .stream()
                .map(locationMapper::toDistrictResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UpazilaResponse> getUpazilasByDistrictIdAndDivisionId(Long districtId, Long divisionId) {
        return upazilaRepository.findByDistrict_IdAndDistrict_Division_Id(districtId, divisionId)
                .stream()
                .map(locationMapper::toUpazilaResponse)
                .toList();
    }
}
