package com.lines.credit.model;

import com.lines.credit.code.FileType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LinesFile {

    private final FileType fileType;
}
