package net.sf.openrocket.file.wavefrontobj.export;

import net.sf.openrocket.file.wavefrontobj.CoordTransform;
import net.sf.openrocket.file.wavefrontobj.DefaultCoordTransform;
import net.sf.openrocket.file.wavefrontobj.ObjUtils;
import net.sf.openrocket.rocketcomponent.Rocket;

public class OBJExportOptions {
    /**
     * If true, export all children of the components as well
     */
    private boolean exportChildren;
    /**
     * If true, export the appearance of the components to an MTL file.
     */
    private boolean exportAppearance;
    /**
     * If true, export each component as a separate OBJ file.
     */
    private boolean exportAsSeparateFiles;
    /**
     * If true, remove the offset of the object so it is centered at the origin (but the bottom of the object is at x=0).
     * 'x' being the longitudinal axis (depends on the used {@link CoordTransform}).
     */
    private boolean removeOffset;
    /**
     * If true, triangulate all faces (convert quads and higher-order polygons to triangles)
     */
    private boolean triangulate;
    /**
     * The level of detail to use for the export (e.g. low-quality, normal quality...).
     */
    private ObjUtils.LevelOfDetail LOD;
    /**
     * The coordinate transformer to use for the export.
     * This is used to convert the coordinates from the rocket's coordinate system to the OBJ coordinate system (which is arbitrary).
     */
    private CoordTransform transformer;

    // TODO: scaling (to mm = x1000, or SI units)

    public OBJExportOptions(Rocket rocket) {
        this.exportChildren = false;
        this.exportAppearance = false;
        this.exportAsSeparateFiles = false;
        this.removeOffset = true;
        this.triangulate = false;
        this.LOD = ObjUtils.LevelOfDetail.NORMAL;
        this.transformer = new DefaultCoordTransform(rocket.getLength());
    }

    public boolean isExportChildren() {
        return exportChildren;
    }

    public void setExportChildren(boolean exportChildren) {
        this.exportChildren = exportChildren;
    }

    public boolean isRemoveOffset() {
        return removeOffset;
    }

    public void setRemoveOffset(boolean removeOffset) {
        this.removeOffset = removeOffset;
    }

    public boolean isTriangulate() {
        return triangulate;
    }

    public void setTriangulate(boolean triangulate) {
        this.triangulate = triangulate;
    }

    public boolean isExportAppearance() {
        return exportAppearance;
    }

    public void setExportAppearance(boolean exportAppearance) {
        this.exportAppearance = exportAppearance;
    }

    public ObjUtils.LevelOfDetail getLOD() {
        return LOD;
    }

    public void setLOD(ObjUtils.LevelOfDetail LOD) {
        this.LOD = LOD;
    }

    public CoordTransform getTransformer() {
        return transformer;
    }

    public void setTransformer(CoordTransform transformer) {
        this.transformer = transformer;
    }

    public boolean isExportAsSeparateFiles() {
        return exportAsSeparateFiles;
    }

    public void setExportAsSeparateFiles(boolean exportAsSeparateFiles) {
        this.exportAsSeparateFiles = exportAsSeparateFiles;
    }
}
