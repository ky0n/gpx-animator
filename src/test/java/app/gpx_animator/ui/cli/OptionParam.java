/*
 *  Copyright Contributors to the GPX Animator project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package app.gpx_animator.ui.cli;

import app.gpx_animator.core.Option;
import app.gpx_animator.core.configuration.TrackConfiguration;
import app.gpx_animator.core.data.Position;
import app.gpx_animator.core.data.SpeedUnit;
import app.gpx_animator.core.data.VideoCodec;
import lombok.Getter;
import java.awt.Color;
import java.awt.Font;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static app.gpx_animator.ui.cli.CommandLineConfigurationFactoryTest.TEST_COLOR_FF_0096;
import static app.gpx_animator.ui.cli.CommandLineConfigurationFactoryTest.TEST_FONT_MONOSPACED_8;


@Getter
public enum OptionParam {

    ATTRIBUTION(Option.ATTRIBUTION,
                false,
                () -> Optional.of("attribution"),
                (factory) -> factory.getConfiguration().getAttribution().equals("attribution")),
    ATTRIBUTION_MARGIN(Option.ATTRIBUTION_MARGIN,
                       false,
                       () -> Optional.of("3333"),
                       (factory) -> factory.getConfiguration().getAttributionMargin() == 3333),
    ATTRIBUTION_POSITION(Option.ATTRIBUTION_POSITION,
                         false,
                         () -> Optional.of("bottom_left"),
                         (factory) -> factory.getConfiguration().getAttributionPosition().equals(Position.BOTTOM_LEFT)),
    BACKGROUND_COLOR(Option.BACKGROUND_COLOR,
                     false,
                     () -> Optional.of(TEST_COLOR_FF_0096),
                     (factory) -> factory.getConfiguration().getBackgroundColor().equals(new Color(16711830,
                                                                                                   true))),
    BACKGROUND_IMAGE(Option.BACKGROUND_IMAGE,
                     false,
                     () -> Optional.of("./src/test/resources/gpx/backgroundImage"),
                     (factory) -> factory.getConfiguration().getBackgroundImage().getName().equals("backgroundImage")),
    BACKGROUND_MAP_VISIBILITY(Option.BACKGROUND_MAP_VISIBILITY,
                              false,
                              () -> Optional.of("2233.56"),
                              (factory) -> factory.getConfiguration().getBackgroundMapVisibility() == 2233.56F),
    COLOR(Option.COLOR,
          true,
          () -> Optional.of(TEST_COLOR_FF_0096),
          (factory) -> getFirstTrackConfiguration(factory).getColor().equals(Color.decode(TEST_COLOR_FF_0096))),
    COMMENT_MARGIN(Option.COMMENT_MARGIN,
                   false,
                   () -> Optional.of("88888"),
                   (factory) -> factory.getConfiguration().getCommentMargin() == 88888),
    COMMENT_POSITION(Option.COMMENT_POSITION,
                     false,
                     () -> Optional.of("BOTTOM_CENTER"),
                     (factory) -> factory.getConfiguration().getCommentPosition().equals(Position.BOTTOM_CENTER)),
    FLASHBACK_COLOR(Option.FLASHBACK_COLOR,
                    false,
                    () -> Optional.of("#FF0090"),
                    (factory) -> factory.getConfiguration().getFlashbackColor().equals(new Color(16711824,
                                                                                                 true))),
    FLASHBACK_DURATION(Option.FLASHBACK_DURATION,
                       false,
                       () -> Optional.of("435353535"),
                       (factory) -> factory.getConfiguration().getFlashbackDuration().equals(435353535L)),
    FONT(Option.FONT,
         false,
         () -> Optional.of(TEST_FONT_MONOSPACED_8),
         (factory) -> factory.getConfiguration().getFont().equals(Font.decode(TEST_FONT_MONOSPACED_8))),
    FORCED_POINT_TIME_INTERVAL(Option.FORCED_POINT_TIME_INTERVAL,
                               true,
                               () -> Optional.of("244"),
                               (factory) -> getFirstTrackConfiguration(factory).getForcedPointInterval().equals(244L)),
    FPS(Option.FPS,
        false,
        () -> Optional.of("244.6"),
        (factory) -> factory.getConfiguration().getFps() == 244.6D),
    GPS_TIMEOUT(Option.GPS_TIMEOUT,
                false,
                () -> Optional.of("899999"),
                (factory) -> factory.getConfiguration().getGpsTimeout() == 899999),
    GUI(Option.GUI,
        false,
        Optional::empty,
        CommandLineConfigurationFactory::isGui),
    HEIGHT(Option.HEIGHT,
           false,
           () -> Optional.of("600"),
           (factory) -> factory.getConfiguration().getHeight().equals(600)),
    HELP(Option.HELP,
         false,
         Optional::empty,
         (factory) -> true),
    INFORMATION(Option.INFORMATION,
                false,
                () -> Optional.of("information"),
                (factory) -> factory.getConfiguration().getInformation().equals("information")),
    INFORMATION_MARGIN(Option.INFORMATION_MARGIN,
                       false,
                       () -> Optional.of("2222"),
                       (factory) -> factory.getConfiguration().getInformationMargin() == 2222),
    INFORMATION_POSITION(Option.INFORMATION_POSITION,
                         false,
                         () -> Optional.of("TOP_CENTER"),
                         (factory) -> factory.getConfiguration().getInformationPosition().equals(Position.TOP_CENTER)),
    INPUT(Option.INPUT,
          false,
          () -> Optional.of("input"),
          (factory) -> getFirstTrackConfiguration(factory).getInputGpx().getName().equals("input")),
    KEEP_FIRST_FRAME(Option.KEEP_FIRST_FRAME,
                     false,
                     () -> Optional.of("353535"),
                     (factory) -> factory.getConfiguration().getKeepFirstFrame().equals(353535L)),
    KEEP_IDLE(Option.KEEP_IDLE,
              false,
              Optional::empty,
              (factory) -> !factory.getConfiguration().isSkipIdle()),
    KEEP_LAST_FRAME(Option.KEEP_LAST_FRAME,
                    false,
                    () -> Optional.of("44444"),
                    (factory) -> factory.getConfiguration().getKeepLastFrame().equals(44444L)),
    LABEL(Option.LABEL,
          true,
          () -> Optional.of("lable"),
          (factory) -> getFirstTrackConfiguration(factory).getLabel().equals("lable")),
    LINE_WIDTH(Option.LINE_WIDTH,
               true,
               () -> Optional.of("40.0"),
               (factory) -> getFirstTrackConfiguration(factory).getLineWidth() == 40.0F),
    LOGO(Option.LOGO,
         false,
         () -> Optional.of("./src/test/resources/gpx/bikeride.gpx"),
         (factory) -> factory.getConfiguration().getLogo().getName().equals("bikeride.gpx")),
    LOGO_MARGIN(Option.LOGO_MARGIN,
                false,
                () -> Optional.of("3454"),
                (factory) -> factory.getConfiguration().getLogoMargin() == 3454),
    LOGO_POSITION(Option.LOGO_POSITION,
                  false,
                  () -> Optional.of("top_center"),
                  (factory) -> factory.getConfiguration().getLogoPosition().equals(Position.TOP_CENTER)),
    MARGIN(Option.MARGIN,
           false,
           () -> Optional.of("10"),
           (factory) -> factory.getConfiguration().getMargin() == 10),
    MARKER_SIZE(Option.MARKER_SIZE,
                false,
                () -> Optional.of("44.6"),
                (factory) -> factory.getConfiguration().getMarkerSize().equals(44.6)),
    MAX_LAT(Option.MAX_LAT,
            false,
            () -> Optional.of("84.6"),
            (factory) -> factory.getConfiguration().getMaxLat().equals(84.6)),
    MAX_LON(Option.MAX_LON,
            false,
            () -> Optional.of("84.6"),
            (factory) -> factory.getConfiguration().getMaxLon().equals(84.6)),
    MIN_LAT(Option.MIN_LAT,
            false,
            () -> Optional.of("44.6"),
            (factory) -> factory.getConfiguration().getMinLat().equals(44.6)),
    MIN_LON(Option.MIN_LON,
            false,
            () -> Optional.of("54.6"),
            (factory) -> factory.getConfiguration().getMinLon().equals(54.6)),
    OUTPUT(Option.OUTPUT,
           false,
           () -> Optional.of("./src/test/resources/gpx/2"),
           (factory) -> factory.getConfiguration().getOutput().getName().equals("2")),
    PHOTO_ANIMATION_DURATION(Option.PHOTO_ANIMATION_DURATION,
                             false,
                             () -> Optional.of("66666"),
                             (factory) -> factory.getConfiguration().getPhotoAnimationDuration().equals(66666L)),
    PHOTO_DIR(Option.PHOTO_DIR,
              false,
              () -> Optional.of("./src/test/resources/gpx/PHOTO_DIR"),
              (factory) -> factory.getConfiguration().getPhotoDirectory().getName().equals("PHOTO_DIR")),
    PHOTO_TIME(Option.PHOTO_TIME,
               false,
               () -> Optional.of("111"),
               (factory) -> factory.getConfiguration().getPhotoTime().equals(111L)),
    PREVIEW_LENGTH(Option.PREVIEW_LENGTH,
                   false,
                   () -> Optional.of("720"),
                   (factory) -> factory.getConfiguration().getPreviewLength().equals(720L)),
    PRE_DRAW_LINE_WIDTH(Option.PRE_DRAW_LINE_WIDTH,
                        true,
                        () -> Optional.of("40.0"),
                        (factory) -> getFirstTrackConfiguration(factory).getPreDrawLineWidth() == 40.0),
    PRE_DRAW_TRACK(Option.PRE_DRAW_TRACK,
                   false,
                   Optional::empty,
                   (factory) -> factory.getConfiguration().isPreDrawTrack()),
    PRE_DRAW_TRACK_COLOR(Option.PRE_DRAW_TRACK_COLOR,
                         true,
                         () -> Optional.of(TEST_COLOR_FF_0096),
                         (factory) -> getFirstTrackConfiguration(factory).getPreDrawTrackColor()
                                 .equals(Color.decode(TEST_COLOR_FF_0096))),
    SKIP_IDLE(Option.SKIP_IDLE,
              false,
              () -> Optional.of("true"),
              (factory) -> factory.getConfiguration().isSkipIdle()),
    SPEEDUP(Option.SPEEDUP,
            false,
            () -> Optional.of("20.0"),
            (factory) -> factory.getConfiguration().getSpeedup().equals(20.0)),
    SPEED_UNIT(Option.SPEED_UNIT,
               false,
               () -> Optional.of("mps"),
               (factory) -> factory.getConfiguration().getSpeedUnit().equals(SpeedUnit.MPS)),
    TAIL_COLOR(Option.TAIL_COLOR,
               false,
               () -> Optional.of("#FF8816"),
               (factory) -> factory.getConfiguration().getTailColor().equals(new Color(16746518,
                                                                                       true))),
    TAIL_COLOR_FADEOUT(Option.TAIL_COLOR_FADEOUT,
                       false,
                       () -> Optional.of("true"),
                       (factory) -> factory.getConfiguration().isTailColorFadeout()),
    TAIL_DURATION(Option.TAIL_DURATION,
                  false,
                  () -> Optional.of("60"),
                  (factory) -> factory.getConfiguration().getTailDuration() == 60),
    TIME_OFFSET(Option.TIME_OFFSET,
                true,
                () -> Optional.of("20"),
                (factory) -> getFirstTrackConfiguration(factory).getTimeOffset().equals(20L)),
    TMS_API_KEY(Option.TMS_API_KEY,
                false,
                () -> Optional.of("tmsApiKey"),
                (factory) -> factory.getConfiguration().getTmsApiKey().equals("tmsApiKey")),
    TMS_URL_TEMPLATE(Option.TMS_URL_TEMPLATE,
                     false,
                     () -> Optional.of("tmsUrlTemplate"),
                     (factory) -> factory.getConfiguration().getTmsUrlTemplate().equals("tmsUrlTemplate")),
    TMS_USER_AGENT(Option.TMS_USER_AGENT,
                   false,
                   () -> Optional.of("tmsUserAgent"),
                   (factory) -> factory.getConfiguration().getTmsUserAgent().equals("tmsUserAgent")),
    TOTAL_TIME(Option.TOTAL_TIME,
               false,
               () -> Optional.of("2233"),
               (factory) -> factory.getConfiguration().getTotalTime().equals(2233L)),
    TRACK_ICON(Option.TRACK_ICON,
               true,
               () -> Optional.of("file"),
               (factory) -> getFirstTrackConfiguration(factory).getTrackIcon().getName().equals("file")),
    TRACK_ICON_FILE(Option.TRACK_ICON_FILE,
                    true,
                    () -> Optional.of("./src/test/resources/TRACK_ICON_FILE"),
                    (factory) -> getFirstTrackConfiguration(factory).getInputIcon().getName()
                            .equals("TRACK_ICON_FILE")),
    TRACK_ICON_MIRROR(Option.TRACK_ICON_MIRROR,
                      true,
                      Optional::empty,
                      (factory) -> getFirstTrackConfiguration(factory).isTrackIconMirrored()),
    TRIM_GPX_END(Option.TRIM_GPX_END,
                 true,
                 () -> Optional.of("42"),
                 (factory) -> getFirstTrackConfiguration(factory).getTrimGpxEnd().equals(42L)),
    TRIM_GPX_START(Option.TRIM_GPX_START,
                   true,
                   () -> Optional.of("22"),
                   (factory) -> getFirstTrackConfiguration(factory).getTrimGpxStart().equals(22L)),
    VERSION(Option.VERSION,
            false,
            Optional::empty,
            (factory) -> true),
    VIDEO_CODEC(Option.VIDEO_CODEC,
                false,
                () -> Optional.of("H.264"),
                (factory) -> factory.getConfiguration().getVideoCodec().equals(VideoCodec.H264)),
    VIEWPORT_HEIGHT(Option.VIEWPORT_HEIGHT,
                    false,
                    () -> Optional.of("640"),
                    (factory) -> factory.getConfiguration().getViewportHeight().equals(640)),
    VIEWPORT_INERTIA(Option.VIEWPORT_INERTIA,
                     false,
                     () -> Optional.of("40"),
                     (factory) -> factory.getConfiguration().getViewportInertia().equals(40)),
    VIEWPORT_WIDTH(Option.VIEWPORT_WIDTH,
                   false,
                   () -> Optional.of("840"),
                   (factory) -> factory.getConfiguration().getViewportWidth().equals(840)),
    WAYPOINT_FONT(Option.WAYPOINT_FONT,
                  false,
                  () -> Optional.of(TEST_FONT_MONOSPACED_8),
                  (factory) -> factory.getConfiguration().getWaypointFont().equals(Font.decode(TEST_FONT_MONOSPACED_8))),
    WAYPOINT_SIZE(Option.WAYPOINT_SIZE,
                  false,
                  () -> Optional.of("944.6"),
                  (factory) -> factory.getConfiguration().getWaypointSize().equals(944.6)),
    WIDTH(Option.WIDTH,
          false,
          () -> Optional.of("800"),
          (factory) -> factory.getConfiguration().getWidth().equals(800)),
    ZOOM(Option.ZOOM,
         false,
         () -> Optional.of("80"),
         (factory) -> factory.getConfiguration().getZoom().equals(80));

    private final Option option;
    private final boolean isNeedTrackConfiguration;
    private final Supplier<Optional<String>> supplierParam;
    private final Function<CommandLineConfigurationFactory, Boolean> checkResult;


    OptionParam(final Option option,
                final boolean isNeedTrackConfiguration,
                final Supplier<Optional<String>> supplierParam,
                final Function<CommandLineConfigurationFactory, Boolean> checkResult) {
        this.option = option;
        this.isNeedTrackConfiguration = isNeedTrackConfiguration;
        this.supplierParam = supplierParam;
        this.checkResult = checkResult;
    }

    public static OptionParam ofOption(final Option option) {
        for (OptionParam op : values()) {
            if (op.option == option) {
                return op;
            }
        }
        throw new RuntimeException("No fount mapping option to optionParam. Please add new param");
    }

    private static TrackConfiguration getFirstTrackConfiguration(final CommandLineConfigurationFactory factory) {
        return factory.getConfiguration().getTrackConfigurationList().get(0);
    }

}
