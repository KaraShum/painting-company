function calcArea(width, height) {
    return width * height;
}

function calcTotalArea(wallWidth, wallHeight, windowWidth, windowHeight) {
    return calcArea(wallWidth, wallHeight) - calcArea(windowWidth, windowHeight);
}

function calcPaintBuckets(totalArea, paintCoverage) {
    return Math.ceil(totalArea / paintCoverage);
}

function calcLanes(wallpaperWidth, wallWidth) {
    return Math.ceil(wallWidth / wallpaperWidth);
}

function calcLangeLength(wallHeight, rapport) {
    const patterns = Math.ceil(wallHeight / rapport);
    return patterns * rapport;
}

function lanesPerRoll(wallpaperLength, laneLength) {
    return Math.floor(wallpaperLength / laneLength);
}

function calcWallpaperRolls(wallwidth, wallHeight, wallpaperLength, wallpaperWidth, rapport) {
    const lanes = calcLanes(wallpaperWidth, wallwidth);
    let laneLength;
    let lPR;
    if (rapport > 0) {
        laneLength = calcLangeLength(wallHeight, rapport);
    } else {
        laneLength = wallHeight;
    }
    lPR = lanesPerRoll(wallpaperLength, laneLength);
    return Math.ceil(lanes / lPR);
}

function calcPrice(count, price) {
    return count * price;
}

export { calcArea, calcLanes, calcLangeLength, lanesPerRoll, calcWallpaperRolls };