package io.ibos.pcs.service.impl;

import io.ibos.pcs.dto.response.DistrictResponse;
import io.ibos.pcs.dto.response.DivisionResponse;
import io.ibos.pcs.dto.response.UpazillaResponse;
import io.ibos.pcs.repository.DistrictRepository;
import io.ibos.pcs.repository.DivisionRepository;
import io.ibos.pcs.repository.UpazillaRepository;
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
    private final UpazillaRepository upazillaRepository;
    private final LocationMapper locationMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DivisionResponse> getAllDivisions() {
        return divisionRepository.findAll()
                .stream()
                .map(locationMapper::toDivisionResponse)
                .toList();
    }

    @Override
    public List<DistrictResponse> getDistrictsByDivisionId(Long divisionId) {
        return districtRepository.findByDivision_Id(divisionId)
                .stream()
                .map(locationMapper::toDistrictResponse)
                .toList();
    }

    @Override
    public List<UpazillaResponse> getUpazillasByDistrictIdAndDivisionId(Long districtId, Long divisionId) {
        return upazillaRepository.findByDistrict_IdAndDistrict_Division_Id(districtId, divisionId)
                .stream()
                .map(locationMapper::toUpazillaResponse)
                .toList();
    }
}
